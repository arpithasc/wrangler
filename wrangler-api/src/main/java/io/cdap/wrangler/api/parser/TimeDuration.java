package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import io.cdap.wrangler.api.annotations.PublicEvolving;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a time duration token (e.g., "150ms", "2s").
 */
@PublicEvolving
public class TimeDuration implements Token {
  private static final Pattern PATTERN = Pattern.compile("(?i)(\\d+(?:\\.\\d+)?)(ms|s|ns)");
  private final long milliseconds;

  public TimeDuration(String input) {
    Matcher matcher = PATTERN.matcher(input.trim());
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid time duration format: " + input);
    }
    double value = Double.parseDouble(matcher.group(1));
    String unit = matcher.group(2).toLowerCase();

    switch (unit) {
      case "ms":
        milliseconds = (long) value;
        break;
      case "s":
        milliseconds = (long) (value * 1000);
        break;
      case "ns":
        milliseconds = (long) (value / 1_000_000);
        break;
      default:
        throw new IllegalArgumentException("Unknown unit: " + unit);
    }
  }

  @Override
  public Object value() {
    return milliseconds;
  }

  @Override
  public TokenType type() {
    return TokenType.TIME_DURATION;
  }

  @Override
  public JsonElement toJson() {
    return new JsonPrimitive(milliseconds);
  }
}

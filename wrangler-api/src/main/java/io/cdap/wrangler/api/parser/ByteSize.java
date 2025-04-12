package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import io.cdap.wrangler.api.annotations.PublicEvolving;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a byte size token (e.g., "10KB", "5MB").
 */
@PublicEvolving
public class ByteSize implements Token {
  private static final Pattern PATTERN = Pattern.compile("(?i)(\\d+(?:\\.\\d+)?)(KB|MB|GB|TB)");
  private final long bytes;

  public ByteSize(String input) {
    Matcher matcher = PATTERN.matcher(input.trim());
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid byte size format: " + input);
    }
    double value = Double.parseDouble(matcher.group(1));
    String unit = matcher.group(2).toUpperCase();

    switch (unit) {
      case "KB":
        bytes = (long) (value * 1024);
        break;
      case "MB":
        bytes = (long) (value * 1024 * 1024);
        break;
      case "GB":
        bytes = (long) (value * 1024 * 1024 * 1024);
        break;
      case "TB":
        bytes = (long) (value * 1024L * 1024 * 1024 * 1024);
        break;
      default:
        throw new IllegalArgumentException("Unknown unit: " + unit);
    }
  }

  @Override
  public Object value() {
    return bytes;
  }

  @Override
  public TokenType type() {
    return TokenType.BYTE_SIZE;
  }

  @Override
  public JsonElement toJson() {
    return new JsonPrimitive(bytes);
  }
}

// ... (existing license and package declarations remain unchanged)

@PublicEvolving
public enum TokenType implements Serializable {
  // --- Existing token types ---
  DIRECTIVE_NAME,
  COLUMN_NAME,
  TEXT,
  NUMERIC,
  BOOLEAN,
  COLUMN_NAME_LIST,
  TEXT_LIST,
  NUMERIC_LIST,
  BOOLEAN_LIST,
  EXPRESSION,
  PROPERTIES,
  RANGES,
  IDENTIFIER,

  /**
   * Represents the enumerated type for the object of {@code ByteSize} type.
   * This type is associated with strings like "10KB", "5MB", "1GB", etc., and
   * is converted internally to a long value representing bytes.
   */
  BYTE_SIZE,

  /**
   * Represents the enumerated type for the object of {@code TimeDuration} type.
   * This type is associated with strings like "150ms", "2s", "500ns", etc., and
   * is converted internally to a long value representing milliseconds.
   */
  TIME_DURATION
}

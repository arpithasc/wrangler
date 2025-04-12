# Directives Grammar

This project defines an ANTLR grammar for a custom directive-based language. The grammar is used to parse and process various types of directives such as expressions, properties, macros, and more.

## Key Features

- **Directives**: Support for various directives, including conditions (`if` statements), loops (`for`), and macros.
- **Properties**: Handling complex properties with support for different types (e.g., numbers, booleans, byte sizes, time durations).
- **Range Expressions**: Syntax for number ranges and property assignments.
- **Lexer Rules**: Includes byte sizes, time durations, and other complex tokens.

## Changes

- **New Directive Subrules**: Expanded the `directive` rule to allow more complex syntax, including `numberRanges`, `properties`, and others.
- **Property Handling**: Added error handling for malformed property lists.
- **Lexer Expansion**: Added support for new token types like `BYTE_SIZE` and `TIME_DURATION`.

## Setup and Usage

1. Clone this repository.
2. Run the ANTLR tool to generate the parser:
   ```bash
   antlr4 Directives.g4


task2:
└── parser
    ├── ByteSize.java        ← New
    ├── TimeDuration.java    ← New
    └── TokenType.java       ← Updated with new enums


Task 3:
 Task 3: Core Parser Updates – wrangler-core
📁 Location
wrangler-core/src/main/java/io/cdap/wrangler/parser/

📝 Description
This task adds support for two new argument types in the Wrangler directive parser:

ByteSize (e.g., "10KB", "5MB")

TimeDuration (e.g., "150ms", "2s")

✅ Changes Made
ANTLR Grammar (Directives.g4) updated with rules for BYTE_SIZE and TIME_DURATION.

Visitor methods implemented in the parser:

visitByteSizeArg

visitTimeDurationArg

New argument tokens now handled via the corresponding ByteSize and TimeDuration classes.

🛠️ How It Works
When the parser encounters tokens like "10KB" or "2s":

It matches them using new grammar rules.

Then calls the appropriate visitor method.

Which returns a ByteSize or TimeDuration object.

Task 4:
Task 4: Implementing the AggregateStats Directive
📁 Location
wrangler-core/src/main/java/io/cdap/wrangler/api/directive

📝 Description
The AggregateStats directive aggregates data by summing byte sizes and calculating the average of time durations from specified source columns, storing the results in designated target columns.

Task 5: Testing
📁 Location
wrangler-core/src/test/java/io/cdap/wrangler/api/parser

📝 Description
Create unit tests for the ByteSize and TimeDuration classes to validate their parsing logic.

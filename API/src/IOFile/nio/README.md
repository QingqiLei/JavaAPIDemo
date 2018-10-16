## in general
The aim of NIO is to increasing speed, the old I/O class has been redesign and can benefit from NIO.

## comparison
- IO is Stream Oriented, NIO is buffer(or mass) oriented
- IO operate the data a byte at a time
- NIO operate the mass of data

## the central abstractions of the NIO APIs are:
- **Buffer**, which are containers for data;
- **Charsets and their associated decoders and encoders**,
  which translate between bytes and Unicode characters;
- **Channels** of various types, which represent connections to
  entities capable of performing IO operations;
- **Selectors and SelectionKeys**

# Huffman Coding Project

This project implements the Huffman coding algorithm for text compression and decompression. It includes a JavaFX-based user interface for encoding and decoding text.

## Features

- Text encoding using Huffman coding
- Text decoding of Huffman-encoded data
- Visual representation of the Huffman tree
- User-friendly GUI for easy interaction

## How to Use

1. Enter the text you want to encode in the input field.
2. Click the "Encode" button to compress the text.
3. The encoded text and the Huffman tree visualization will be displayed.
4. To decode, enter the encoded text and click the "Decode" button.

## Implementation

This project is implemented in Java and uses JavaFX for the graphical user interface. The core algorithm is based on Huffman's original work on variable-length codes for data compression [1].

## Sample Usage

### Input Text
From there I was on another three-month mission to oversee the set-up of the office in New York.

### Output
Frequency Map:
{ =17, a=2, c=1, e=13, f=3, F=1, h=6, i=4, I=1, k=1, -=2, m=3, .=1, N=1, n=5, o=10, p=1, r=6, s=5, t=8, u=1, v=1, w=2, Y=1}

Huffman Codes:
{ =00, a=111101, c=1101000, e=101, f=10000, F=1101010, h=1001, I=1101001, i=11100, k=1110101, m=10001, -=111011, .=1101011, N=1101101, n=11111, o=010, p=1110100, r=0111, s=0110, t=1100, u=1111000, v=1111001, w=110111, Y=1101100}

Encoded Text:
110101001110101000100110010011010111101001101001001101111111010110000101111100111101111110101100100110101110011001001011110110111101110001010111111100100100100011110001100110111000101111100110001000010111100110101110110101101001100100110100011010111001110111111000111010000010100000011001001101000101000010000111001101000101001110011111001101101101110111001101100010011111101011101011

Compression Rate: 50,00%

Huffman Tree:
Internal (96)
├── Internal (38)
│.   ├──   (17)
│.   └── Internal (21)
│.       ├── o (10)
│.       └── Internal (11)
│.           ├── s (5)
│.           └── r (6)
└── Internal (58)
├── Internal (25)
│.   ├── Internal (12)
│.   │.   ├── Internal (6)
│.   │.   │.   ├── f (3)
│.   │.   │.   └── m (3)
│.   │.   └── h (6)
│.   └── e (13)
└── Internal (33)
├── Internal (16)
│.   ├── t (8)
│.   └── Internal (8)
│.       ├── Internal (4)
│.       │.   ├── Internal (2)
│.       │.   │.   ├── c (1)
│.       │.   │.   └── I (1)
│.       │.   └── Internal (2)
│.       │.       ├── F (1)
│.       │.       └── . (1)
│.       └── Internal (4)
│.           ├── Internal (2)
│.           │.   ├── Y (1)
│.           │.   └── N (1)
│.           └── w (2)
└── Internal (17)
├── Internal (8)
│.   ├── i (4)
│.   └── Internal (4)
│.       ├── Internal (2)
│.       │.   ├── p (1)
│.       │.   └── k (1)
│.       └── - (2)
└── Internal (9)
├── Internal (4)
│.   ├── Internal (2)
│.   │.   ├── u (1)
│.   │.   └── v (1)
│.   └── a (2)
└── n (5)

## References

[1] Huffman, D.A., 1952. A Method for the Construction of Minimum-Redundancy Codes. Proceedings of the IRE, 40(9), pp.1098-1101.

[2] Cormen, T.H., Leiserson, C.E., Rivest, R.L. and Stein, C., 2009. Introduction to Algorithms. 3rd ed. MIT Press. (Chapter on Greedy Algorithms, Huffman Codes)

[3] Sedgewick, R. and Wayne, K., 2011. Algorithms. 4th ed. Addison-Wesley Professional. (Section on Huffman Compression)

## License

MIT licence


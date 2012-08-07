## Programs information
    From: University of Kent
    Name: PicoBlazeData
    Language: Java
    Date: August 2012


## Description

This program is used to create some fake data packets, it does not
create a real packet, it only generate the content of the packet.
The result will be automatically convert into VHDL language.


## How to use it

./picoBlazeRule words_file

You can choose between two outputs.

Display the list of the words that you want in the packet:

    DataPacket dataPacket = new DataPacket(args[0]);
    dataPacket.print(WORDS);

Or you can output the VHDL code:

    DataPacket dataPacket = new DataPacket(args[0]);
    dataPacket.print(OUTPUT);


## Words file example

    his
    her
    she


## Output example

print(WORDS):
    his
    her
    she

print(OUTPUT):
    INIT_00 => X"AC61B2D0101CDE6B3036902FC5B81231326812E0707959F6CF146837DF606EC9",
    INIT_01 => X"63DDF6716CE9F1611AEAF530CEF43141AF4AE373101DDA6879BE109D51E38B9D",
    INIT_02 => X"C279FBB3E75B851A5D51BAA4970B5A999268265786A614F25E137ED33E66FD1B",
    INIT_03 => X"485424F66417D848715BE07C736968ADA5BD9345DD51F7BAB6E142DA28796BFA"

## Contact

    David Carnot
    dc386@kent.ac.uk

    Jean-Charles Le Goff
    jcl28@kent.ac.uk

    Valentin Briand
    vb86@kent.ac.uk

    Michael Bishaey
    mb551@kent.ac.uk
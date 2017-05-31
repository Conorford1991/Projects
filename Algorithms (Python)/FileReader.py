'''
Author: Conor Ford
FileReader class
'''

# File reader method ("rb" opening for [r]eading as [b]inary )
def FileRead(File):
    # open file
    FileIn = open(File, "rb")

    # file read
    plaintext_bytes = FileIn.read()

    # file close
    FileIn.close()

    # return file
    return plaintext_bytes

# Read key method
def KeyRead():
    # open file
    FileIn = open("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt", "rb")

    # file read
    plaintext_bytes = FileIn.read()

    # file close
    FileIn.close()

    # return file
    return plaintext_bytes

# write ciphertext to file
def EncryptedFileWriter(Text,AlgoType):
    # open file
    FileIn = open("C:\\Users\\Conor\\Desktop\\Project Demo\\Encrypted Files\\ " + AlgoType + " (Python).txt", "w")

    # file write
    FileIn.write(Text)

    # file close
    FileIn.close()

# write plaintext to file
def DecryptedFileWriter(Text,AlgoType):
    # open file
    FileIn = open("C:\\Users\\Conor\\Desktop\\Project Demo\\Decrypted Files\\ " + AlgoType + " (Python).txt", "w")

    # file write
    FileIn.write(Text)

    # file close
    FileIn.close()
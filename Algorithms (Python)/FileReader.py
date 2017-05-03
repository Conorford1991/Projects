# File reader method ("rb" opening for [r]eading as [b]inary )
def FileRead():
    FileIn = open("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Testing.txt", "rb")
    plaintext_bytes = FileIn.read()
    FileIn.close()

    return plaintext_bytes

def KeyRead():
    FileIn = open("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt", "rb")
    plaintext_bytes = FileIn.read()
    FileIn.close()

    return plaintext_bytes
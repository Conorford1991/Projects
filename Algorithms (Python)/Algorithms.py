import AES
import Blowfish
import DES
import TDES
import RSA
import FileReader

#Modules
# OS module
import os


def AES_call():
    # File reader call
    plaintext_bytes = FileReader.FileRead()

    # Encrypt call
    ciphertext_bytes, iv, key = AES.Encrypt(plaintext_bytes)

    # Decrypt call
    AES.Decrypt(ciphertext_bytes, iv, key)



def Blowfish_call():
    # File reader call
    plaintext_bytes = FileReader.FileRead()

    # Encrypt call
    ciphertext_bytes, iv, key = Blowfish.Encrypt(plaintext_bytes)

    # Decrypt call
    Blowfish.Decrypt(ciphertext_bytes, iv, key)


def DES_call():
    # File reader call
    plaintext_bytes = FileReader.FileRead()

    # Encrypt call
    ciphertext_bytes, iv, key = DES.Encrypt(plaintext_bytes)

    # Decrypt call
    DES.Decrypt(ciphertext_bytes, iv, key)


def TDES_call():
    # File reader call
    plaintext_bytes = FileReader.FileRead()

    # Encrypt call
    ciphertext_bytes, iv, key = TDES.Encrypt(plaintext_bytes)

    # Decrypt call
    TDES.Decrypt(ciphertext_bytes, iv, key)


def RSA_call():
    # File reader call
    plaintext_bytes = FileReader.KeyRead()

    # Encrypt call
    ciphertext_bytes, iv, key = RSA.Encrypt(plaintext_bytes)

    # Decrypt call
    RSA.Decrypt(ciphertext_bytes, iv, key)

def main():
    plaintext = FileReader.FileRead()
    print("Plaintext prior to encryption: ", plaintext)

    AES_call()
    Blowfish_call()
    DES_call()
    TDES_call()

    keytext = FileReader.KeyRead()
    print("AES key prior to RSA encryption: ", keytext)
    RSA_call()

main()

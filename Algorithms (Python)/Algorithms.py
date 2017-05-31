'''
Author: Conor Ford
Algorithms class
'''

# imports
import AES
import Blowfish
import DES
import TDES
import RSA
import FileReader

#Modules
# OS module
import os
import time
# Performance analysis (output expressed in bytes)
import psutil



def AES_call(DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader.FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = AES.Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    AES.Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Print
    print("AES encryption time: ",Encryptend - Encryptstart)
    print("AES decryption time: ",Decryptend - Decryptstart)
    print("AES CPU usage: ",(psutil.cpu_percent(interval=1))," percent")
    print("AES Memory usage: ",(psutil.virtual_memory())," bytes")
    print("----------------------------------------------")


def Blowfish_call(DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader.FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Blowfish.Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Blowfish.Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Print
    print("Blowfish encryption time: ", Encryptend - Encryptstart)
    print("Blowfish decryption time: ", Decryptend - Decryptstart)
    print("Blowfish CPU usage: ", (psutil.cpu_percent(interval=1)), " percent")
    print("Blowfish Memory usage: ", (psutil.virtual_memory()), " bytes")
    print("----------------------------------------------")

def DES_call(DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader.FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = DES.Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    DES.Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Print
    print("DES encryption time: ", Encryptend - Encryptstart)
    print("DES decryption time: ", Decryptend - Decryptstart)
    print("DES CPU usage: ", (psutil.cpu_percent(interval=1)), " percent")
    print("DES Memory usage: ", (psutil.virtual_memory()), " bytes")
    print("----------------------------------------------")


def TDES_call(DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader.FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = TDES.Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    TDES.Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Print
    print("TDES encryption time: ", Encryptend - Encryptstart)
    print("TDES decryption time: ", Decryptend - Decryptstart)
    print("TDES CPU usage: ", (psutil.cpu_percent(interval=1)), " percent")
    print("TDES Memory usage: ", (psutil.virtual_memory()), " bytes")
    print("----------------------------------------------")


def RSA_call():
    # File reader call
    plaintext_bytes = FileReader.KeyRead()

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = RSA.Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    RSA.Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Print
    print("RSA encryption time: ", Encryptend - Encryptstart)
    print("RSA decryption time: ", Decryptend - Decryptstart)
    print("RSA CPU usage: ", (psutil.cpu_percent(interval=1)), " percent")
    print("RSA Memory usage: ", (psutil.virtual_memory()), " bytes")
    print("----------------------------------------------")

def UserInput():

    ExecutionSelect = input("Start or End execution")

    while(ExecutionSelect != "End"):

        AlgorithmSelect = input("Select Algorithm: AES, Blowfish, TDES, DES, RSA, All (all algorithms)")

        DataSizeSelect = input("Select Data size (MB): Testing (1KB), 20, 40, 60, 80, 100")

        if (DataSizeSelect == "Testing"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Testing.txt"

        elif (DataSizeSelect == "20"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 20.txt"

        elif (DataSizeSelect == "40"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 40.txt"

        elif (DataSizeSelect == "60"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 60.txt"

        elif (DataSizeSelect == "80"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 80.txt"

        elif (DataSizeSelect == "100"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 100.txt"

        else:
            print("Invalid data input, try again")
            UserInput()

        if (AlgorithmSelect == "AES"):
            AES_call(DataSizeSelect)
            UserInput()

        elif (AlgorithmSelect == "Blowfish"):
            Blowfish_call(DataSizeSelect)
            UserInput()

        elif (AlgorithmSelect == "TDES"):
            TDES_call(DataSizeSelect)
            UserInput()

        elif (AlgorithmSelect == "DES"):
            DES_call(DataSizeSelect)
            UserInput()

        elif (AlgorithmSelect == "RSA"):
            RSA_call()
            UserInput()

        elif (AlgorithmSelect == "All"):
            AES_call(DataSizeSelect)
            Blowfish_call(DataSizeSelect)
            TDES_call(DataSizeSelect)
            DES_call(DataSizeSelect)
            RSA_call()
            UserInput()

        else:
            print("Invalid algorithm input, try again")
            UserInput()

        break



def main():
    # UserInput call
    UserInput()

# main call
main()

/*
Author: Conor Ford
header class
*/

/* stdafx.h : include file for standard system include files,
or project specific include files that are used frequently, but
 are changed infrequently
*/

#pragma once

#include "targetver.h"
#include <stdio.h>
#include <tchar.h>

// cryptlib.h provides basic abstractions for the Crypto++ library. 
#include "..\Crypto++\cryptlib.h"
// Crypto++ exposes most AES encrpytion and decryption operations through aes.h.
#include "..\Crypto++\aes.h"
// Crypto++ exposes most DES encryption and decryption operations through des.h.
#include "..\Crypto++\des.h"
// Crypto++ exposes most Blowfish encryption and decryption operations through des.h.
#include "..\Crypto++\blowfish.h"
// Crypto++ exposes most RSA encrpytion and decryption operations through rsa.h.
#include "..\Crypto++\rsa.h"
// AutoSeededRandomPool
#include "..\Crypto++\osrng.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>
// Cipher mode CBC, ECB etc.
#include "..\Crypto++\modes.h"
// The HexEncoder encodes bytes into base 16 encoded data, making it easier to display
#include "..\Crypto++\hex.h"


using namespace std;
using namespace CryptoPP;


// File reader
string FileReader(string DataSizeSelect);

// Key reader
string KeyReader();

// FileWriter
void EncryptedFileWriter(string text, string AlgoType);
void DecryptedFileWriter(string text, string AlgoType);

// AES
string AESEncrypt(string plaintext, SecByteBlock key, byte IV[AES::BLOCKSIZE]);
void AESDecrypt(string ciphertext, SecByteBlock key, byte IV[AES::BLOCKSIZE]);

// DES
string DESEncrypt(string plaintext, SecByteBlock key, byte IV[DES::BLOCKSIZE]);
void DESDecrypt(string ciphertext, SecByteBlock key, byte IV[DES::BLOCKSIZE]);

// TDES
string TDESEncrypt(string plaintext, SecByteBlock key, byte IV[DES_EDE3::BLOCKSIZE]);
void TDESDecrypt(string ciphertext, SecByteBlock key, byte IV[DES_EDE3::BLOCKSIZE]);

// Blowfish
string BlowfishEncrypt(string plaintext, SecByteBlock key, byte IV[Blowfish::BLOCKSIZE]);
void BlowfishDecrypt(string ciphertext, SecByteBlock key, byte IV[Blowfish::BLOCKSIZE]);

// RSA
string RSAEncrypt(RSA::PublicKey publicKey, string plaintext, AutoSeededRandomPool& rand); 
void RSADecrypt(RSA::PrivateKey privateKey, string ciphertext, AutoSeededRandomPool& rand);

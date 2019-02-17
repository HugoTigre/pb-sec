# Security utils for encryption and decryption


Important: this service has <a href="https://github.com/abstractj/kalium">kalium</a> as a dependency,
which itself needs <a href="https://github.com/jedisct1/libsodium">libsodium</a> installed
directly in the operating system for this to work. For more on this please read the Kalium documentation.

<a href="http://macappstore.org/libsodium/">Install libsodium in macos</a>

# Usage

Just instantiate ```EncryptionUtils```, manually or through DI, and look at the available methods and documentation.

# History

This library was initially created to add this functionality to the Play Framework,
which, i think after version 2.5, decided that this kind of functionality shouldn't 
be provided by the framework.
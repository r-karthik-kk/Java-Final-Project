// package com.backend;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// public class GenerateHash {

//     public static void main(String[] args) {

//         if (args.length == 0) {
//             System.out.println("Usage: GenerateHash <password>");
//             return;
//         }

//         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//         String hash = encoder.encode(args[0]);

//         System.out.println("Password : " + args[0]);
//         System.out.println("Hash     : " + hash);
//     }
// }
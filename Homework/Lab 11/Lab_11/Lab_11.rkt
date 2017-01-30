;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname Lab_11) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
;CSC 172 Spring 2016
;Lab_11
;Author: Rajat Kuthiala
;Email: rkuthial@u.rochester.edu
 

;Lab TA: Shuyang
 

(define (mygcd a b)
  (cond ((= b 0) a)
        (else (mygcd b modulo a b )))
  )

(gcd 12 6)
(gcd 25 5)
(gcd 145 15)
(gcd 96 76)
(gcd 543 72)
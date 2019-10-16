	
(set-weight (w TROP))
(set-logic LIA)

(synth-fun eq1 ( (x1 Int) (x2 Int) (x3 Int) (x4 Int) (x5 Int) (x6 Int) (x7 Int) (x8 Int) (x9 Int) (x10 Int)) Int ((Start Int (0 1
             ((+ Start var):1)
             (+ Start Start)
             (ite StartBool Start Start)))
(var Int (x1 x2 x3 x4 x5 x6 x7 x8 x9 x10))
 (StartBool Bool (           (not StartBool) (or StartBool)       (>= Start Start) (and StartBool StartBool) ))
))

(define-fun iteB (( b1 Bool ) (b2 Bool ) (b3 Bool )) Bool ( or ( and b1 b2 ) ( and (not b1 ) b3 ) ) )
(define-fun plus2 ((b1 Int) (b2 Int)) Int ( + b1 b2))
(define-fun plus3 ((b1 Int) (b2 Int) (b3 Int)) Int ( +  ( + b1 b2) b3))
(define-fun plus4 ((b1 Int) (b2 Int) (b3 Int) (b4 Int)) Int ( +  ( plus3  b1 b2 b3) b4))
(define-fun plus5 ((b1 Int) (b2 Int) (b3 Int) (b4 Int) (b5 Int)) Int (+  ( plus4 b1 b2 b3 b4) b5))
(define-fun plus6 ((b1 Int) (b2 Int) (b3 Int) (b4 Int) (b5 Int) (b6 Int) ) Int (+  ( plus5 b1 b2 b3 b4  b5) b6  ))
(define-fun plus7 ((b1 Int) (b2 Int) (b3 Int) (b4 Int) (b5 Int) (b6 Int) (b7 Int)) Int (+  ( plus6 b1 b2 b3 b4  b5 b6 ) b7  ))
(define-fun plus8 ((b1 Int) (b2 Int) (b3 Int) (b4 Int) (b5 Int) (b6 Int) (b7 Int) (be Int)) Int (+  ( plus7 b1 b2 b3 b4  b5 b6 b7) be  ))
(define-fun plus9 ((b1 Int) (b2 Int) (b3 Int) (b4 Int) (b5 Int) (b6 Int) (b7 Int) (be Int) (bn Int)) Int (+  ( plus8 b1 b2 b3 b4  b5 b6 b7 be) bn  ))

(define-fun or3 ((b1 Bool) (b2 Bool) (b3 Bool)) Bool ( or ( or b1 b2) b3))
(define-fun one-times  ((b1 Int )) Int b1)
(define-fun two-times  ((b1 Int )) Int ( plus2 b1 b1))
(define-fun three-times  ((b1 Int )) Int ( plus3 b1 b1 b1))
(define-fun five-times  ((b1 Int )) Int ( plus5 b1 b1 b1 b1 b1 ))
(define-fun seven-times ((b1 Int )) Int ( plus7 b1 b1 b1 b1 b1 b1 b1 ))
(define-fun nine-times  ((b1 Int )) Int ( plus9 b1 b1 b1 b1 b1 b1 b1 b1 b1))
(define-fun ten-times  ((b1 Int )) Int ( plus9 b1 b1 b1 b1 b1 b1 b1 b1 ( plus2 b1 b1 )))
(define-fun minus ((b1 Int)) Int ( - 0  b1 ))

(declare-var x Int ) 
(declare-var y Int ) 
(declare-var z Int ) 



( constraint ( = ( eq1 x y z ) ( plus3 (three-times x ) (three-times y) 3 ) ) )      


(check-synth)


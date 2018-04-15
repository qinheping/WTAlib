(set-weight (w1 TROP) )
(set-logic BV)

(define-fun parity ((a Bool) (b Bool) (c Bool) (d Bool)) Bool
  (xor (not (xor a b)) (not (xor c d))))

(synth-fun AIG ((a Bool) (b Bool) (c Bool) (d Bool)) Bool
 ((Start Bool (((and Start Start):0) ((not Start):1)  a b c d))))

(declare-var a Bool)
(declare-var b Bool)
(declare-var c Bool)
(declare-var d Bool)

(constraint
 (= (parity a b c d) 
    (and (AIG a b c d)
        (not (and (and (not (and a b)) (not (and (not a) (not b))))
               (and (not (and (not c) (not d))) (not (and c d))))))))

(optimize w1)
(check-synth)



(set-weight (w1 TROP) )
(set-logic LIA)

(synth-fun max4 ((x Int) (y Int) (z Int)) Int

((Start Int (x y 0 1 z
             (+ Start Start)
             (- Start Start)
             ((ite StartBool Start Start) : 1)))

 (StartBool Bool ((and StartBool StartBool)
                  (or StartBool StartBool)
                  (not StartBool)
                  (<= Start Start)
                  (= Start Start)
                  (>= Start Start)))))

(declare-var x Int)
(declare-var y Int)
(declare-var z Int)


(constraint (>= (max4 x y z) x))
(constraint (>= (max4 x y z) y))
(constraint (>= (max4 x y z) z))
(constraint (or (= x (max4 x y z ))
            (or (= y (max4 x y z))
             (= z (max4 x y z))))))
 
(weight-constraint (<= w1 1))
(optimize w1)

(check-synth)

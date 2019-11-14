(set-weight (w1 TROP) )
(set-logic LIA)

(synth-fun max4 ((x Int) (y Int) (z Int) (w Int)) Int

((Start Int (x y 0 1
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
(declare-var w Int)


(constraint (>= (max4 x y z w) x))
(constraint (>= (max4 x y z w) y))
(constraint (>= (max4 x y z w) z))
(constraint (>= (max4 x y z w) w))
(constraint (or (= x (max4 x y z w))
            (or (= y (max4 x y z w))
            (or (= z (max4 x y z w))
	        (= w (max4 x y z w))))))
 
(weight-constraint (<= w1 2))
(optimize w1)

(check-synth)

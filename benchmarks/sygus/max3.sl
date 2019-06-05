(set-weight (w1 TROP) )
(set-logic LIA)

(synth-fun max3 ((x Int) (y Int) (z Int) (w1 Int)) Int
    ((Start Int (x
                 y
		 w1
                 z
                 0
                 1
                 (+ Start Start)
                 ((ite StartBool Start Start):1)))
     (StartBool Bool ((==  Start Start)
                      (>=  Start Start)))))

(declare-var x Int)
(declare-var y Int)
(declare-var z Int)

(constraint (>= (max3 x y z) x))
(constraint (>= (max3 x y z) y))
(constraint (>= (max3 x y z) z))
(constraint (or (= x (max3 x y z))
            (or (= y (max3 x y z))
                (= z (max3 x y z)))))
(optimize w1)

(check-synth)


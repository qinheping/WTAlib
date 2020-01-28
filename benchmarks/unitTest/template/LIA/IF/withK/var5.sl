(set-weight (w TROP))
(set-logic LIA)

(synth-fun findSum ((x1 Int) (x2 Int) (x3 Int) (x4 Int)  (x5 Int)) Int
    ((Start Int (x1
		x2
		x3
		x4
		x5
                 0
                 1
                 ((+ Start Start):1)
                 (ite StartBool Start Start)))
     (StartBool Bool ((and StartBool StartBool)
                      (or  StartBool StartBool)
                      (not StartBool)
                      ((<=  Start Start):1)
                      (=   Start Start)
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

(weight-constraint (>= w 1))
(check-synth)


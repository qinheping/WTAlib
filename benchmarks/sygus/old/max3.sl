(set-weight (w1 TROP) )
(set-logic LIA)

(synth-fun max3 ((x Int) (y Int)) Int
    ((Start Int (x
                 y
                 0
                 1
                 ((+ Start Start) : 1)
                 (ite StartBool Start Start)))
     (StartBool Bool ( (>=  Start Start)))))

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


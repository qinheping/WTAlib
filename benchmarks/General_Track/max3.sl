; max3.sl
; Synthesize the maximum of 3 integers, from a purely declarative spec

(set-logic LIA)

(synth-fun max3 ((x Int) (y Int) (z Int)) Int
    ((Start Int (x
                 y
                 z
                 0
                 1
                 ((+ Start Start):1)
                 ((- Start Start):1)
                 ((ite StartBool Start Start):10)))
     (StartBool Bool (((and StartBool StartBool):1)
                      ((or  StartBool StartBool):1)
                      ((not StartBool):1)
                      ((<=  Start Start):1)
                      ((=   Start Start):1)
                      ((>=  Start Start):1)))))

(declare-var x Int)
(declare-var y Int)
(declare-var z Int)

(constraint (>= (max3 x y z) x))
(constraint (>= (max3 x y z) y))
(constraint (>= (max3 x y z) z))
(constraint (or (= x (max3 x y z))
            (or (= y (max3 x y z))
                (= z (max3 x y z)))))

(check-synth)


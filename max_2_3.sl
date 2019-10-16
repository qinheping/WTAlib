(set-weight (w1 TROP) )
(set-logic LIA)

(declare-var x Int)
(declare-var y Int)
(synth-fun max2 ((x Int) (y Int)) Int

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



(constraint (>= (max2 x y) x))
(constraint (>= (max2 x y) y))
(constraint (or (= x (max2 x y)) (= y (max2 x y))))

(weight-constraint (= w1 1))
(optimize w1)

(check-synth)

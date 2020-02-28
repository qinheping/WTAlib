

(set-logic LIA)
(synth-fun findSum ((y1 Int) (y2 Int) (y3 Int) (y4 Int)) Int
((Start Int ( y1 y2 y3 y4
  3
             (+ Start Start)
             (ite StartBool Start Start)))
 (StartBool Bool (           (not StartBool) (or StartBool)       (>= Start Start) (and StartBool StartBool) ))
))
 
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var x3 Int)
(declare-var x4 Int)

(constraint (=> (> (+ x1 x2) 5) (= (findSum x1 x2 x3 x4) (+ x1 x2))))
(constraint (=> (and (<= (+ x1 x2) 5) (> (+ x2 x3) 5)) (= (findSum x1 x2 x3 x4) (+ x2 x3))))
(constraint (=> (and (and (<= (+ x1 x2) 5) (<= (+ x2 x3) 5)) (> (+ x3 x4) 5)) (= (findSum x1 x2 x3 x4) (+ x3 x4))))
(constraint (=> (and (and (<= (+ x1 x2) 5) (<= (+ x2 x3) 5)) (<= (+ x3 x4) 5)) (= (findSum x1 x2 x3 x4) 0)))


(check-synth)
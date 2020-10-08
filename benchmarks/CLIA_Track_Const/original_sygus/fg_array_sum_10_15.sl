
(set-weight (w TROP))
(set-logic LIA)
(synth-fun findSum ( (y1 Int) (y2 Int) (y3 Int) (y4 Int) (y5 Int) (y6 Int) (y7 Int) (y8 Int) (y9 Int) (y10 Int) )Int 
((Start Int (  
    3 
		y1 y2 y3 y4 y5 y6 y7 y8 y9 y10
             (+ Start Start)
             (ite StartBool Start Start)))
 (StartBool Bool (           (not StartBool)      (>= Start Start) (and StartBool StartBool) ))
))
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var x3 Int)
(declare-var x4 Int)
(declare-var x5 Int)
(declare-var x6 Int)
(declare-var x7 Int)
(declare-var x8 Int)
(declare-var x9 Int)
(declare-var x10 Int)
(constraint (=> (> (+ x1 x2) 15) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x1 x2))))
(constraint (=> (and (<= (+ x1 x2) 15) (> (+ x2 x3) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x2 x3))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (<= (+ x2 x3) 15)) (> (+ x3 x4) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x3 x4))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (<= (+ x3 x4) 15))) (> (+ x4 x5) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x4 x5))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (<= (+ x4 x5) 15)))) (> (+ x5 x6) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x5 x6))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (and (<= (+ x4 x5) 15) (<= (+ x5 x6) 15))))) (> (+ x6 x7) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x6 x7))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (and (<= (+ x4 x5) 15) (and (<= (+ x5 x6) 15) (<= (+ x6 x7) 15)))))) (> (+ x7 x8) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x7 x8))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (and (<= (+ x4 x5) 15) (and (<= (+ x5 x6) 15) (and (<= (+ x6 x7) 15) (<= (+ x7 x8) 15))))))) (> (+ x8 x9) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x8 x9))))
(constraint (=> (and (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (and (<= (+ x4 x5) 15) (and (<= (+ x5 x6) 15) (and (<= (+ x6 x7) 15) (and (<= (+ x7 x8) 15) (<= (+ x8 x9) 15)))))))) (> (+ x9 x10) 15)) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) (+ x9 x10))))
(constraint (=> (and (<= (+ x1 x2) 15) (and (<= (+ x2 x3) 15) (and (<= (+ x3 x4) 15) (and (<= (+ x4 x5) 15) (and (<= (+ x5 x6) 15) (and (<= (+ x6 x7) 15) (and (<= (+ x7 x8) 15) (and (<= (+ x8 x9) 15) (<= (+ x9 x10) 15))))))))) (= (findSum x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 ) 0)))
(check-synth)


(set-logic LIA)
(synth-fun findSum  (        ( x1  Int )  ( x2  Int )  ( x3  Int )  ( x4  Int )  ( x5  Int ) )  Int (
		(Start  Int (		x1 x2  x3 x4 x5
	0 1 (+ Start Start) (- Start Start) (ite B Start Start)
))
	(B Bool (		(and B B) (or B B) (not B) (= Start Start) (<= Start Start) (>= Start Start)
))
	
))

(declare-var x1 Int)
(declare-var x2 Int)
(declare-var x3 Int)
(declare-var x4 Int)
(declare-var x5 Int)

(constraint (=> (> (+ x1 x2) 5) (= (findSum x1 x2 x3 x4 x5) (+ x1 x2))))
(constraint (=> (and (<= (+ x1 x2) 5) (> (+ x2 x3) 5)) (= (findSum x1 x2 x3 x4 x5) (+ x2 x3))))
(constraint (=> (and (and (<= (+ x1 x2) 5) (<= (+ x2 x3) 5)) (> (+ x3 x4) 5)) (= (findSum x1 x2 x3 x4 x5) (+ x3 x4))))
(constraint (=> (and (and (and (<= (+ x1 x2) 5) (<= (+ x2 x3) 5)) (<= (+ x3 x4) 5)) (> (+ x4 x5) 5)) (= (findSum x1 x2 x3 x4 x5) (+ x4 x5))))
(constraint (=> (and (and (and (<= (+ x1 x2) 5) (<= (+ x2 x3) 5)) (<= (+ x3 x4) 5)) (<= (+ x4 x5) 5)) (= (findSum x1 x2 x3 x4 x5) 0)))

(check-synth)
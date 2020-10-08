(set-logic LIA)
(synth-fun findSum  (      ( x1  Int )  ( x2  Int )  ( x3  Int ) )  Int (
	(Start  Int (		x1 x2  x3
	0 1 (+ Start Start) (- Start Start) (ite B Start Start)
))
	(B Bool (		(and B B) (or B B) (not  B) (= Start Start) (<= Start Start) (>= Start Start)
))
	
))
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var x3 Int)
(constraint (=> (> (+ x1 x2) 15) (= (findSum x1 x2 x3 ) (+ x1 x2))))
(constraint (=> (and (<= (+ x1 x2) 15) (> (+ x2 x3) 15)) (= (findSum x1 x2 x3 ) (+ x2 x3))))
(constraint (=> (and (<= (+ x1 x2) 15) (<= (+ x2 x3) 15)) (= (findSum x1 x2 x3 ) 0)))
(check-synth)

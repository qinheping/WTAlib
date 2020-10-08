(set-logic LIA)
(synth-fun findSum (      ( x1  Int )  ( x2  Int ) )  Int (
	(Start  Int (		x1 x2  
	0 1 (+ Start Start) (- Start Start) (ite B Start Start)
))
	(B Bool (		(and B B) (or B B) (not B) (= Start Start) (<= Start Start) (>= Start Start)
))
	
))

(declare-var x1 Int)
(declare-var x2 Int)
(constraint (=> (> (+ x1 x2) 15) (= (findSum x1 x2 ) (+ x1 x2))))
(constraint (=> (<= (+ x1 x2) 15) (= (findSum x1 x2 ) 0)))
(check-synth)

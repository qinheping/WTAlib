(set-logic LIA)
(synth-fun findIdx ( (x1 Int) (x2 Int) (k Int)) Int  (
	(Start  Int (		x1 x2 k
	0 1 (+ Start Start) (- Start Start) (ite B Start Start)
))
	(B Bool (		(and B B) (or B B) (not B) (= Start Start) (<= Start Start) (>= Start Start)
))
	
))
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var k Int)
(constraint (=> (< x1 x2) (=> (< k x1) (= (findIdx x1 x2 k) 0))))
(constraint (=> (< x1 x2) (=> (> k x2) (= (findIdx x1 x2 k) 2))))
(constraint (=> (< x1 x2) (=> (and (> k x1) (< k x2)) (= (findIdx x1 x2 k) 1))))
(check-synth)

(set-logic LIA)

(synth-fun max2 ((x Int) (y Int)) Int (
			(Start  Int (		x y
	0 1 (+ Start Start) (- Start Start) (ite B Start Start)
))
	(B Bool (		(and B B) (or B B) (not  B) (= Start Start) (<= Start Start) (>= Start Start)
))
))


(declare-var x Int)
(declare-var y Int)

(constraint (>= (max2 x y) x))
(constraint (>= (max2 x y) y))
(constraint (or (= x (max2 x y))
				(= y (max2 x y))))


(check-synth)


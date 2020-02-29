(set-logic HORN)
(declare-fun Start (Int ) Bool)
(assert (Start -16))
(assert (Start 49))
(assert (Start 0))
(assert (Start 1))
(assert (forall ((x_0_0 Int) (x_1_0 Int) )
 (=> (and (Start x_0_0) (Start x_1_0) ) (Start (+ x_0_0 x_1_0)))))


(assert (forall ( (x_0 Int) )
	(=> (Start  x_0 ) (not (and
		(= x_0 49)
)))))
(check-sat)
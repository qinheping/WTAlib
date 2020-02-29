(set-logic HORN)
(declare-fun Start (Int ) Bool)
(declare-fun StartBool (Bool ) Bool)
(assert (Start 0))
(assert (Start 0))
(assert (Start 6))
(assert (forall ((x_0_0 Int) (x_1_0 Int) )
 (=> (and (Start x_0_0) (Start x_1_0) ) (Start (+ x_0_0 x_1_0)))))

(assert (forall ((x_0_0 Bool) (x_1_0 Int) (x_2_0 Int) )
 (=> (and (StartBool x_0_0) (Start x_1_0) (Start x_2_0) ) (Start (ite x_0_0 x_1_0 x_2_0)))))

(assert (forall ((x_0_0 Bool) )
 (=> (and (StartBool x_0_0) ) (StartBool (not x_0_0)))))

(assert (forall ((x_0_0 Bool) )
 (=> (and (StartBool x_0_0) ) (StartBool (or x_0_0)))))

(assert (forall ((x_0_0 Int) (x_1_0 Int) )
 (=> (and (Start x_0_0) (Start x_1_0) ) (StartBool (>= x_0_0 x_1_0)))))

(assert (forall ((x_0_0 Bool) (x_1_0 Bool) )
 (=> (and (StartBool x_0_0) (StartBool x_1_0) ) (StartBool (and x_0_0 x_1_0)))))


(assert (forall ( (x_0 Int) )
	(=> (Start  x_0 ) (not (and
		(= x_0 1)
)))))
(check-sat)
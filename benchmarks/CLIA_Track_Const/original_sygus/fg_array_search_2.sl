(set-logic LIA)
(synth-fun findIdx ( (x Int) (y Int) (z Int)) Int ((Start Int (x y  3 z
             (+ Start Start)
             (ite StartBool Start Start)))
 (StartBool Bool (           (not StartBool)       (>= Start Start) (and StartBool StartBool) ))
))
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var kt Int)
(constraint (=> (< x1 x2) (=> (< kt x1) (= (findIdx x1 x2 kt) 0))))
(constraint (=> (< x1 x2) (=> (> kt x2) (= (findIdx x1 x2 kt) 2))))
(constraint (=> (< x1 x2) (=> (and (> kt x1) (< kt x2)) (= (findIdx x1 x2 kt) 1))))
(check-synth)

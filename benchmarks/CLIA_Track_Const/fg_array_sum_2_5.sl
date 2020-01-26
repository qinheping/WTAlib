(set-logic LIA)
(synth-fun findSum ( (x Int) (y Int) )Int ((Start Int (x y 0 1
             (+ Start Start)
             ((ite StartBool Start Start):1)))
 (StartBool Bool (                  (>= Start Start)))))
(declare-var x1 Int)
(declare-var x2 Int)
(constraint (=> (> (+ x1 x2) 5) (= (findSum x1 x2 ) (+ (+ x1 x2) 1))))
(constraint (=> (<= (+ x1 x2) 5) (= (findSum x1 x2 ) 0)))
(check-synth)
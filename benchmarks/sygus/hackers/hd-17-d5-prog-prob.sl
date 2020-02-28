(set-weight (w PROB))
(set-logic BV)

(define-fun hd17 ((x (BitVec 32))) (BitVec 32) (bvand (bvadd (bvor x (bvsub x #x00000001)) #x00000001) x))

(synth-fun f ((x (BitVec 32))) (BitVec 32)
    ((Start (BitVec 32) (((bvnot Start):0.125)
						 ((bvxor Start Start):0.125)
						 ((bvand Start Start):0.125)
						 ((bvor Start Start) : 0.125)
						 ((bvneg Start):0.125)
						 ((bvadd Start Start):0.25)
						 ((bvmul Start Start):0.25)
						 ((bvudiv Start Start):0.25)
						 ((bvurem Start Start):0.25)
						 ((bvlshr Start Start):0.5)
						 ((bvashr Start Start):0.5)
						 ((bvshl Start Start):0.5)
						 ((bvsdiv Start Start):0.5)
						 ((bvsrem Start Start):0.5)
						 ((bvsub Start Start):0.5)
                         x
						 #x00000000
						 #xffffffff
                         #x00000001))))


(declare-var x (BitVec 32))
(constraint (= (hd17 x) (f x)))
(optimize w)
(check-synth)


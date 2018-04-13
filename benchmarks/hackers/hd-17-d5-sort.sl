(set-weight (w1 TROP) (w2 TROP))
(set-logic BV)

(define-fun hd17 ((x (BitVec 32))) (BitVec 32) (bvand (bvadd (bvor x (bvsub x #x00000001)) #x00000001) x))

(synth-fun f ((x (BitVec 32))) (BitVec 32)
    ((Start (BitVec 32) (((bvnot Start):0 1)
						 ((bvxor Start Start):0 1)
						 ((bvand Start Start):1 1)
						 ((bvor Start Start) :0 1)
						 ((bvneg Start):0 1)
						 ((bvadd Start Start):0 1)
						 ((bvmul Start Start):0 1)
						 ((bvudiv Start Start):0 1)
						 ((bvurem Start Start):0 1)
						 ((bvlshr Start Start):0 1)
						 ((bvshl Start Start):0 1)
						 ((bvsdiv Start Start):0 1)
						 ((bvsub Start Start):0 1)
                         x
						 #x0000001F
						 #x00000001
						 #x00000000
						 #xFFFFFFFF))))

(declare-var x (BitVec 32))
(constraint (= (hd17 x) (f x)))
(optimize (SORT w1 w2))
(check-synth)


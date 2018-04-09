(set-weight TROP)

(set-logic BV)

(define-fun hd07 ((x (BitVec 32))) (BitVec 32) (bvand (bvnot x) (bvadd x #x00000001)))

(synth-fun f ((x (BitVec 32))) (BitVec 32)
    ((Start (BitVec 32) (((bvnot Start):3)
						 ((bvxor Start Start):3)
						 ((bvand Start Start):3)
						 ((bvor Start Start) : 3)
						 ((bvneg Start):3)
						 ((bvadd Start Start):2)
						 ((bvmul Start Start):2)
						 ((bvudiv Start Start):2)
						 ((bvurem Start Start):2)
						 ((bvlshr Start Start):1)
						 ((bvashr Start Start):1)
						 ((bvshl Start Start):1)
						 ((bvsdiv Start Start):1)
						 ((bvsrem Start Start):1)
						 ((bvsub Start Start):1)
                         #x00000000
						 #x00000001
						 #xFFFFFFFF
                         x))))

(declare-var x (BitVec 32))
(constraint (= (hd07 x) (f x)))
(check-synth)


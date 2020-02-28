(set-weight TROP)
(set-logic BV)

(define-fun hd09 ((x (BitVec 32))) (BitVec 32) (bvsub (bvxor x (bvashr x #x0000001F)) (bvashr x #x0000001F)))

(synth-fun f ((x (BitVec 32))) (BitVec 32)
    ((Start (BitVec 32) (((bvnot Start):1)
						 ((bvxor Start Start):1)
						 ((bvand Start Start):1)
						 ((bvor Start Start) : 1)
						 ((bvneg Start):0)
						 ((bvadd Start Start):0)
						 ((bvmul Start Start):0)
						 ((bvudiv Start Start):0)
						 ((bvurem Start Start):0)
						 ((bvlshr Start Start):0)
						 ((bvashr Start Start):0)
						 ((bvshl Start Start):0)
						 ((bvsdiv Start Start):0)
						 ((bvsrem Start Start):0)
						 ((bvsub Start Start):0)
                         x
						 #x00000000
						 #xFFFFFFFF
                         #x00000001))))

(declare-var x (BitVec 32))
(constraint (= (hd09 x) (f x)))
(check-synth)


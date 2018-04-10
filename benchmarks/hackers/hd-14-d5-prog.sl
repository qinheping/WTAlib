(set-weight TROP)


(set-logic BV)

(define-fun hd14 ((x (BitVec 32)) (y (BitVec 32))) (BitVec 32) (bvadd (bvand x y) (bvlshr (bvxor x y) #x00000001)))

(synth-fun f ((x (BitVec 32)) (y (BitVec 32))) (BitVec 32)
    ((Start (BitVec 32) (((bvnot Start):1)
						 ((bvxor Start Start):1)
						 ((bvand Start Start):1)
						 ((bvor Start Start) : 1)
						 ((bvneg Start):1)
						 ((bvadd Start Start):1)
						 ((bvmul Start Start):1)
						 ((bvudiv Start Start):1)
						 ((bvurem Start Start):1)
						 ((bvlshr Start Start):1)
						 ((bvashr Start Start):1)
						 ((bvshl Start Start):1)
						 ((bvsdiv Start Start):1)
						 ((bvsrem Start Start):1)
						 ((bvsub Start Start):1)
                         x
						 y
						 #x0000001F
						 #x00000001
						 #x00000000
						 #xFFFFFFFF))))

(declare-var x (BitVec 32))
(declare-var y (BitVec 32))
(constraint (= (hd14 x y) (f x y)))
(check-synth)


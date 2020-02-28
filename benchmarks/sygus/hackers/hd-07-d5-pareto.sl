(set-weight (w1 TROP) (w2 TROP))

(set-logic BV)

(define-fun hd07 ((x (BitVec 32))) (BitVec 32) (bvand (bvnot x) (bvadd x #x00000001)))

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
						 ((bvashr Start Start):0 1)
						 ((bvshl Start Start):0 1)
						 ((bvsdiv Start Start):0 1)
						 ((bvsrem Start Start):0 1)
						 ((bvsub Start Start):0 1)
                         #x00000001
						 #x00000000
						 #xffffffff
                         x))))

(declare-var x (BitVec 32))
(constraint (= (hd07 x) (f x)))
(optimize (PARETO w1 w2))
(check-synth)


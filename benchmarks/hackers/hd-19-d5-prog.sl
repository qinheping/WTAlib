(set-weight TROP)
(set-logic BV)

(define-fun hd19 ((x (BitVec 32)) (m (BitVec 32)) (k (BitVec 32))) (BitVec 32) 
  (bvxor x (bvxor (bvshl (bvand (bvxor (bvlshr x k) x) m) k) (bvand (bvxor (bvlshr x k) x) m))))

(synth-fun f ((x (BitVec 32)) (m (BitVec 32)) (k (BitVec 32))) (BitVec 32)
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
						 m
						 k
						 #x0000001F
						 #x00000001
						 #x00000000
						 #xFFFFFFFF))))


(declare-var x (BitVec 32))
(declare-var m (BitVec 32))
(declare-var k (BitVec 32))

(constraint (= (hd19 x m k) (f x m k)))
(check-synth)


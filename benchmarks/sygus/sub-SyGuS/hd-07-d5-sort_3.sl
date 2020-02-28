; constraint : w2 < 5.0
; constraint : w1 < 0.0
; constraint : w1 > 0.0
  ( set-logic BV )
  ( define-fun hd07  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 )  ( bvand     ( bvnot    x )  ( bvadd     x   #x00000001 ) ) )
( synth-fun f  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 ) (
	(Start  ( BitVec 32 ) (		#x00000001
		#x00000000
		#xffffffff
		x
		(bvnot NT0)
		(bvneg NT0)
		(bvadd NT0 NT0)
		(bvadd NT4 NT0)
		(bvadd NT5 NT0)
		(bvadd NT6 NT0)
		(bvor NT0 NT0)
		(bvor NT4 NT0)
		(bvor NT5 NT0)
		(bvor NT6 NT0)
		(bvxor NT0 NT0)
		(bvxor NT4 NT0)
		(bvxor NT5 NT0)
		(bvxor NT6 NT0)
		(bvmul NT0 NT0)
		(bvmul NT4 NT0)
		(bvmul NT5 NT0)
		(bvmul NT6 NT0)
		(bvudiv NT0 NT0)
		(bvudiv NT4 NT0)
		(bvudiv NT5 NT0)
		(bvudiv NT6 NT0)
		(bvurem NT0 NT0)
		(bvurem NT4 NT0)
		(bvurem NT5 NT0)
		(bvurem NT6 NT0)
		(bvlshr NT0 NT0)
		(bvlshr NT4 NT0)
		(bvlshr NT5 NT0)
		(bvlshr NT6 NT0)
		(bvsrem NT0 NT0)
		(bvsrem NT4 NT0)
		(bvsrem NT5 NT0)
		(bvsrem NT6 NT0)
		(bvashr NT0 NT0)
		(bvashr NT4 NT0)
		(bvashr NT5 NT0)
		(bvashr NT6 NT0)
		(bvshl NT0 NT0)
		(bvshl NT4 NT0)
		(bvshl NT5 NT0)
		(bvshl NT6 NT0)
		(bvsdiv NT0 NT0)
		(bvsdiv NT4 NT0)
		(bvsdiv NT5 NT0)
		(bvsdiv NT6 NT0)
		(bvsub NT0 NT0)
		(bvsub NT4 NT0)
		(bvsub NT5 NT0)
		(bvsub NT6 NT0)
		(bvnot NT4)
		(bvneg NT4)
		(bvadd NT4 NT4)
		(bvor NT4 NT4)
		(bvxor NT4 NT4)
		(bvmul NT4 NT4)
		(bvudiv NT4 NT4)
		(bvurem NT4 NT4)
		(bvlshr NT4 NT4)
		(bvsrem NT4 NT4)
		(bvashr NT4 NT4)
		(bvshl NT4 NT4)
		(bvsdiv NT4 NT4)
		(bvsub NT4 NT4)
		(bvnot NT5)
		(bvneg NT5)
		(bvnot NT6)
		(bvneg NT6)
))
	(NT0  ( BitVec 32 ) (		#x00000001
		#x00000000
		#xffffffff
		x
))
	(NT4  ( BitVec 32 ) (		(bvnot NT0)
		(bvneg NT0)
		(bvadd NT0 NT0)
		(bvor NT0 NT0)
		(bvxor NT0 NT0)
		(bvmul NT0 NT0)
		(bvudiv NT0 NT0)
		(bvurem NT0 NT0)
		(bvlshr NT0 NT0)
		(bvsrem NT0 NT0)
		(bvashr NT0 NT0)
		(bvshl NT0 NT0)
		(bvsdiv NT0 NT0)
		(bvsub NT0 NT0)
))
	(NT5  ( BitVec 32 ) (		(bvadd NT4 NT0)
		(bvor NT4 NT0)
		(bvxor NT4 NT0)
		(bvmul NT4 NT0)
		(bvudiv NT4 NT0)
		(bvurem NT4 NT0)
		(bvlshr NT4 NT0)
		(bvsrem NT4 NT0)
		(bvashr NT4 NT0)
		(bvshl NT4 NT0)
		(bvsdiv NT4 NT0)
		(bvsub NT4 NT0)
		(bvnot NT4)
		(bvneg NT4)
))
	(NT6  ( BitVec 32 ) (		(bvadd NT5 NT0)
		(bvor NT5 NT0)
		(bvxor NT5 NT0)
		(bvmul NT5 NT0)
		(bvudiv NT5 NT0)
		(bvurem NT5 NT0)
		(bvlshr NT5 NT0)
		(bvsrem NT5 NT0)
		(bvashr NT5 NT0)
		(bvshl NT5 NT0)
		(bvsdiv NT5 NT0)
		(bvsub NT5 NT0)
		(bvadd NT4 NT4)
		(bvor NT4 NT4)
		(bvxor NT4 NT4)
		(bvmul NT4 NT4)
		(bvudiv NT4 NT4)
		(bvurem NT4 NT4)
		(bvlshr NT4 NT4)
		(bvsrem NT4 NT4)
		(bvashr NT4 NT4)
		(bvshl NT4 NT4)
		(bvsdiv NT4 NT4)
		(bvsub NT4 NT4)
		(bvnot NT5)
		(bvneg NT5)
))
))
  ( declare-var x  ( BitVec 32 ) )
  ( constraint  ( =     ( hd07    x )  ( f    x ) ) )
  ( check-synth )
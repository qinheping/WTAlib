; constraint : w2 < 4.0
; constraint : w1 < 1.0
; constraint : w1 > 0.0
  ( set-logic BV )
  ( define-fun hd17  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 )  ( bvand     ( bvadd     ( bvor     x  ( bvsub     x   #x00000001 ) )   #x00000001 )  x ) )
( synth-fun f  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 ) (
	(Start  ( BitVec 32 ) (		x
		#x0000001f
		#x00000001
		#x00000000
		#xffffffff
		(bvnot NT1)
		(bvneg NT1)
		(bvudiv NT1 NT1)
		(bvxor NT1 NT1)
		(bvor NT1 NT1)
		(bvadd NT1 NT1)
		(bvmul NT1 NT1)
		(bvurem NT1 NT1)
		(bvlshr NT1 NT1)
		(bvshl NT1 NT1)
		(bvsdiv NT1 NT1)
		(bvsub NT1 NT1)
))
	(NT1  ( BitVec 32 ) (		x
		#x0000001f
		#x00000001
		#x00000000
		#xffffffff
		(bvnot NT1)
		(bvneg NT1)
		(bvudiv NT1 NT1)
		(bvxor NT1 NT1)
		(bvor NT1 NT1)
		(bvadd NT1 NT1)
		(bvmul NT1 NT1)
		(bvurem NT1 NT1)
		(bvlshr NT1 NT1)
		(bvshl NT1 NT1)
		(bvsdiv NT1 NT1)
		(bvsub NT1 NT1)
))
))
  ( declare-var x  ( BitVec 32 ) )
  ( constraint  ( =     ( hd17    x )  ( f    x ) ) )
  ( check-synth )

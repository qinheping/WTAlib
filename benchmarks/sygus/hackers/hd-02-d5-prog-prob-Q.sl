  ( set-logic BV )
  ( define-fun hd02  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 )  ( bvand     x  ( bvadd     x   #x00000001 ) ) )
( synth-fun f  (    ( x  ( BitVec 32 ) ) )  ( BitVec 32 ) (
	(Start  ( BitVec 32 ) (		NT1
		NT2
		NT3
))
	(NT1  ( BitVec 32 ) (		#xFFFFFFFF
		x
		#x00000000
		#x00000001
))
	(NT2  ( BitVec 32 ) (		(bvashr NT3 NT1)
		(bvshl NT3 NT1)
		(bvsdiv NT3 NT1)
		(bvlshr NT3 NT1)
		(bvmul NT1 NT1)
		(bvudiv NT1 NT1)
		(bvsrem NT3 NT1)
		(bvadd NT1 NT1)
		(bvurem NT1 NT1)
		(bvsub NT3 NT1)
))
	(NT3  ( BitVec 32 ) (		(bvshl NT1 NT1)
		(bvlshr NT1 NT1)
		(bvsrem NT1 NT1)
		(bvsub NT1 NT1)
		(bvsdiv NT1 NT1)
		(bvashr NT1 NT1)
))
))
  ( declare-var x  ( BitVec 32 ) )
  ( constraint  ( =     ( hd02    x )  ( f    x ) ) )
  ( check-synth )



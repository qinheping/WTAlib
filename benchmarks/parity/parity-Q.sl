( set-logic BV )
  ( define-fun parity  (       ( a  Bool )  ( b  Bool )  ( c  Bool )  ( d  Bool ) )  Bool  ( xor     ( not    ( xor     a  b ) )  ( not    ( xor     c  d ) ) ) )
( synth-fun AIG  (       ( a  Bool )  ( b  Bool )  ( c  Bool )  ( d  Bool ) )  Bool (
	(Start  Bool (		NT1
		NT2
		NT3
		NT4
		NT5
		NT6
		NT7
		NT8
		NT9
))
	(NT1  Bool (		c
		b
		a
		(and NT1 NT1)
		d
))
	(NT2  Bool (		(not NT1)
		(and NT2 NT1)
))
	(NT3  Bool (		(not NT2)
		(and NT3 NT1)
		(and NT2 NT2)
))
	(NT4  Bool (		(and NT3 NT3)
		(not NT5)
		(and NT4 NT1)
))
	(NT5  Bool (		(and NT5 NT1)
		(not NT3)
))
	(NT6  Bool (		(and NT4 NT4)
		(and NT6 NT1)
		(not NT9)
))
	(NT7  Bool (		(and NT7 NT1)
		(and NT5 NT5)
		(not NT8)
))
	(NT8  Bool (		(not NT4)
		(and NT8 NT1)
))
	(NT9  Bool (		(and NT9 NT1)
		(not NT7)
))
))
  ( declare-var a  Bool )
  ( declare-var b  Bool )
  ( declare-var c  Bool )
  ( declare-var d  Bool )
  ( constraint  ( =     ( parity       a  b  c  d )  ( and     ( AIG       a  b  c  d )  ( not    ( and     ( and     ( not    ( and     a  b ) )  ( not    ( and     ( not    a )  ( not    b ) ) ) )  ( and     ( not    ( and     ( not    c )  ( not    d ) ) )  ( not    ( and     c  d ) ) ) ) ) ) ) )
  ( check-synth )

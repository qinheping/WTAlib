( set-logic LIA )
( synth-fun eq1  (      ( x  Int )  ( y  Int )  ( z  Int ) )  Int (
	(Start  Int (		NT2
		NT1
		NT4
		NT6
		NT13
		NT30
		NT39
		NT56
		NT25
		NT42
		NT57
		NT11
		NT31
		NT65
		NT61
		NT24
		NT66
		NT58
		NT9
		NT14
		NT32
		NT67
		NT62
		NT26
		NT68
		NT59
		NT15
		NT33
		NT69
		NT63
		NT27
		NT70
		NT60
		NT5
		NT12
		NT16
		NT34
		NT71
		NT64
		NT28
		NT22
		NT35
		NT40
		NT10
		NT29
		NT38
		NT36
		NT23
		NT37
		NT41
))
	(NT1  Int (		y
		1
		x
		z
		0
))
	(NT2  Int (		(- NT1 NT1)
		(+ NT1 NT1)
))
	(NT3  Bool (		(= NT1 NT1)
		(<= NT1 NT1)
		(not NT3)
		(>= NT1 NT1)
))
	(NT4  Int (		(+ NT2 NT1)
		(- NT2 NT1)
		(ite NT3 NT1 NT1)
))
	(NT5  Int (		(- NT4 NT1)
		(+ NT2 NT2)
		(ite NT3 NT2 NT1)
		(ite NT7 NT1 NT1)
		(- NT2 NT2)
		(+ NT4 NT1)
		(ite NT3 NT1 NT2)
))
	(NT6  Int (		(ite NT3 NT4 NT1)
		(ite NT3 NT2 NT2)
		(- NT5 NT1)
		(+ NT5 NT1)
		(ite NT8 NT1 NT1)
))
	(NT7  Bool (		(>= NT2 NT1)
		(not NT7)
		(= NT2 NT1)
		(and NT3 NT3)
		(or NT3 NT3)
		(<= NT2 NT1)
))
	(NT8  Bool (		(and NT7 NT3)
		(>= NT4 NT1)
		(<= NT4 NT1)
		(<= NT2 NT2)
		(>= NT2 NT2)
		(not NT8)
		(= NT4 NT1)
		(= NT2 NT2)
		(or NT7 NT3)
))
	(NT9  Int (		(+ NT6 NT1)
		(- NT4 NT4)
		(+ NT4 NT4)
		(ite NT17 NT1 NT1)
		(ite NT7 NT1 NT4)
		(- NT6 NT1)
		(ite NT3 NT5 NT1)
		(ite NT7 NT4 NT1)
))
	(NT10  Int (		(ite NT7 NT6 NT1)
		(ite NT7 NT4 NT4)
		(ite NT8 NT1 NT5)
		(ite NT18 NT1 NT1)
		(ite NT7 NT1 NT6)
		(- NT5 NT5)
		(- NT12 NT1)
		(ite NT3 NT9 NT1)
		(+ NT5 NT5)
		(ite NT8 NT5 NT1)
		(+ NT12 NT1)
))
	(NT11  Int (		(ite NT8 NT9 NT1)
		(ite NT3 NT10 NT1)
		(- NT13 NT1)
		(- NT6 NT6)
		(ite NT7 NT12 NT1)
		(ite NT43 NT1 NT1)
		(+ NT6 NT6)
		(+ NT13 NT1)
		(ite NT7 NT5 NT5)
))
	(NT12  Int (		(ite NT3 NT6 NT1)
		(ite NT8 NT4 NT1)
		(ite NT8 NT1 NT4)
		(+ NT9 NT1)
		(- NT9 NT1)
		(ite NT7 NT1 NT5)
		(ite NT7 NT5 NT1)
		(ite NT19 NT1 NT1)
))
	(NT13  Int (		(ite NT8 NT4 NT4)
		(+ NT10 NT1)
		(ite NT20 NT1 NT1)
		(ite NT8 NT6 NT1)
		(ite NT7 NT9 NT1)
		(ite NT3 NT12 NT1)
		(ite NT8 NT1 NT6)
		(- NT10 NT1)
))
	(NT14  Int (		(+ NT11 NT1)
		(ite NT17 NT9 NT1)
		(ite NT8 NT12 NT1)
		(ite NT21 NT1 NT1)
		(ite NT7 NT10 NT1)
		(ite NT17 NT1 NT9)
		(ite NT3 NT13 NT1)
		(- NT11 NT1)
		(ite NT8 NT5 NT5)
))
	(NT15  Int (		(ite NT19 NT1 NT9)
		(ite NT17 NT1 NT12)
		(ite NT17 NT12 NT1)
		(ite NT7 NT13 NT1)
		(+ NT14 NT1)
		(+ NT9 NT9)
		(ite NT44 NT1 NT1)
		(ite NT3 NT11 NT1)
		(ite NT7 NT6 NT6)
		(ite NT19 NT9 NT1)
		(- NT14 NT1)
		(ite NT8 NT10 NT1)
		(- NT9 NT9)
))
	(NT16  Int (		(ite NT18 NT9 NT1)
		(ite NT48 NT1 NT1)
		(- NT15 NT1)
		(ite NT19 NT1 NT12)
		(ite NT7 NT11 NT1)
		(ite NT8 NT6 NT6)
		(ite NT17 NT10 NT1)
		(ite NT18 NT1 NT9)
		(ite NT3 NT14 NT1)
		(+ NT15 NT1)
		(ite NT19 NT12 NT1)
		(ite NT17 NT1 NT10)
		(ite NT8 NT13 NT1)
))
	(NT17  Bool (		(or NT7 NT7)
		(not NT17)
		(or NT8 NT3)
		(>= NT5 NT1)
		(and NT7 NT7)
		(= NT5 NT1)
		(and NT8 NT3)
		(<= NT5 NT1)
))
	(NT18  Bool (		(or NT19 NT3)
		(<= NT9 NT1)
		(or NT8 NT8)
		(and NT8 NT8)
		(not NT18)
		(>= NT9 NT1)
		(= NT9 NT1)
		(and NT19 NT3)
))
	(NT19  Bool (		(= NT4 NT4)
		(or NT17 NT3)
		(>= NT6 NT1)
		(and NT17 NT3)
		(>= NT4 NT4)
		(= NT6 NT1)
		(<= NT6 NT1)
		(<= NT4 NT4)
		(not NT19)
))
	(NT20  Bool (		(>= NT12 NT1)
		(not NT20)
		(>= NT5 NT5)
		(or NT18 NT3)
		(<= NT5 NT5)
		(= NT12 NT1)
		(= NT5 NT5)
		(and NT18 NT3)
		(<= NT12 NT1)
))
	(NT21  Bool (		(and NT43 NT3)
		(<= NT6 NT6)
		(>= NT6 NT6)
		(= NT13 NT1)
		(= NT6 NT6)
		(or NT43 NT3)
		(>= NT13 NT1)
		(not NT21)
		(<= NT13 NT1)
))
	(NT22  Int (		(ite NT8 NT11 NT1)
		(ite NT17 NT13 NT1)
		(+ NT12 NT12)
		(ite NT19 NT10 NT1)
		(- NT12 NT12)
		(ite NT19 NT1 NT10)
		(- NT16 NT1)
		(ite NT45 NT1 NT1)
		(ite NT7 NT14 NT1)
		(ite NT20 NT1 NT9)
		(ite NT20 NT9 NT1)
		(ite NT17 NT1 NT13)
		(ite NT18 NT1 NT12)
		(+ NT16 NT1)
		(ite NT3 NT15 NT1)
		(ite NT18 NT12 NT1)
))
	(NT23  Int (		(ite NT20 NT1 NT10)
		(+ NT10 NT10)
		(ite NT17 NT9 NT9)
		(+ NT29 NT1)
		(ite NT21 NT1 NT9)
		(ite NT46 NT1 NT1)
		(ite NT8 NT15 NT1)
		(- NT29 NT1)
		(ite NT17 NT1 NT14)
		(ite NT21 NT9 NT1)
		(ite NT18 NT1 NT13)
		(ite NT19 NT11 NT1)
		(ite NT20 NT10 NT1)
		(ite NT18 NT13 NT1)
		(ite NT7 NT16 NT1)
		(ite NT19 NT1 NT11)
		(ite NT17 NT14 NT1)
		(ite NT3 NT22 NT1)
		(- NT10 NT10)
))
	(NT24  Int (		(ite NT19 NT22 NT1)
		(ite NT21 NT1 NT11)
		(ite NT20 NT1 NT15)
		(- NT11 NT11)
		(ite NT8 NT23 NT1)
		(ite NT18 NT1 NT16)
		(ite NT20 NT15 NT1)
		(ite NT7 NT30 NT1)
		(- NT31 NT1)
		(+ NT31 NT1)
		(ite NT47 NT1 NT1)
		(ite NT17 NT29 NT1)
		(+ NT11 NT11)
		(ite NT21 NT11 NT1)
		(ite NT18 NT16 NT1)
		(ite NT3 NT25 NT1)
		(ite NT18 NT12 NT12)
		(ite NT17 NT10 NT10)
))
	(NT25  Int (		(ite NT18 NT1 NT14)
		(ite NT20 NT1 NT11)
		(+ NT13 NT13)
		(ite NT18 NT14 NT1)
		(ite NT18 NT9 NT9)
		(ite NT21 NT1 NT10)
		(- NT13 NT13)
		(ite NT20 NT11 NT1)
		(ite NT17 NT12 NT12)
		(+ NT30 NT1)
		(ite NT72 NT1 NT1)
		(ite NT8 NT22 NT1)
		(ite NT17 NT1 NT16)
		(ite NT17 NT16 NT1)
		(ite NT7 NT29 NT1)
		(ite NT19 NT15 NT1)
		(ite NT21 NT10 NT1)
		(ite NT19 NT1 NT15)
		(ite NT3 NT23 NT1)
		(- NT30 NT1)
))
	(NT26  Int (		(ite NT21 NT15 NT1)
		(ite NT8 NT25 NT1)
		(ite NT21 NT1 NT15)
		(ite NT18 NT10 NT10)
		(ite NT3 NT24 NT1)
		(ite NT17 NT30 NT1)
		(ite NT73 NT1 NT1)
		(ite NT7 NT31 NT1)
		(ite NT18 NT29 NT1)
		(ite NT20 NT22 NT1)
		(ite NT17 NT13 NT13)
		(- NT14 NT14)
		(+ NT14 NT14)
		(- NT32 NT1)
		(+ NT32 NT1)
		(ite NT19 NT23 NT1)
))
	(NT27  Int (		(ite NT18 NT13 NT13)
		(ite NT17 NT11 NT11)
		(ite NT21 NT22 NT1)
		(ite NT20 NT23 NT1)
		(ite NT18 NT30 NT1)
		(ite NT3 NT26 NT1)
		(ite NT43 NT29 NT1)
		(ite NT74 NT1 NT1)
		(ite NT8 NT24 NT1)
		(+ NT33 NT1)
		(- NT33 NT1)
		(- NT15 NT15)
		(ite NT43 NT1 NT29)
		(ite NT7 NT32 NT1)
		(ite NT19 NT25 NT1)
		(+ NT15 NT15)
		(ite NT17 NT31 NT1)
))
	(NT28  Int (		(ite NT8 NT26 NT1)
		(ite NT21 NT23 NT1)
		(+ NT16 NT16)
		(ite NT44 NT1 NT29)
		(ite NT18 NT31 NT1)
		(ite NT19 NT24 NT1)
		(ite NT43 NT1 NT30)
		(ite NT7 NT33 NT1)
		(ite NT20 NT25 NT1)
		(ite NT44 NT29 NT1)
		(+ NT34 NT1)
		(ite NT17 NT14 NT14)
		(- NT16 NT16)
		(ite NT3 NT27 NT1)
		(ite NT43 NT30 NT1)
		(ite NT17 NT32 NT1)
		(ite NT48 NT1 NT22)
		(- NT34 NT1)
		(ite NT18 NT11 NT11)
		(ite NT48 NT22 NT1)
		(ite NT75 NT1 NT1)
))
	(NT29  Int (		(ite NT19 NT1 NT13)
		(ite NT20 NT12 NT1)
		(+ NT22 NT1)
		(ite NT17 NT11 NT1)
		(- NT22 NT1)
		(ite NT18 NT10 NT1)
		(ite NT19 NT13 NT1)
		(ite NT49 NT1 NT1)
		(ite NT7 NT15 NT1)
		(ite NT17 NT1 NT11)
		(ite NT3 NT16 NT1)
		(ite NT8 NT14 NT1)
		(ite NT18 NT1 NT10)
		(ite NT20 NT1 NT12)
))
	(NT30  Int (		(ite NT50 NT1 NT1)
		(ite NT19 NT14 NT1)
		(ite NT17 NT1 NT15)
		(ite NT19 NT1 NT14)
		(ite NT17 NT15 NT1)
		(ite NT20 NT1 NT13)
		(ite NT18 NT1 NT11)
		(ite NT21 NT1 NT12)
		(ite NT18 NT11 NT1)
		(ite NT7 NT22 NT1)
		(ite NT8 NT16 NT1)
		(ite NT19 NT9 NT9)
		(+ NT23 NT1)
		(ite NT3 NT29 NT1)
		(- NT23 NT1)
		(ite NT21 NT12 NT1)
		(ite NT20 NT13 NT1)
))
	(NT31  Int (		(ite NT7 NT23 NT1)
		(ite NT18 NT1 NT15)
		(ite NT19 NT16 NT1)
		(ite NT20 NT1 NT14)
		(ite NT20 NT9 NT9)
		(ite NT17 NT22 NT1)
		(ite NT19 NT12 NT12)
		(- NT25 NT1)
		(ite NT20 NT14 NT1)
		(ite NT19 NT1 NT16)
		(ite NT21 NT1 NT13)
		(+ NT25 NT1)
		(ite NT18 NT15 NT1)
		(ite NT8 NT29 NT1)
		(ite NT52 NT1 NT1)
		(ite NT21 NT13 NT1)
		(ite NT3 NT30 NT1)
))
	(NT32  Int (		(ite NT18 NT22 NT1)
		(ite NT51 NT1 NT1)
		(+ NT24 NT1)
		(ite NT20 NT12 NT12)
		(ite NT19 NT10 NT10)
		(ite NT20 NT16 NT1)
		(ite NT8 NT30 NT1)
		(- NT24 NT1)
		(ite NT21 NT1 NT14)
		(ite NT17 NT23 NT1)
		(ite NT3 NT31 NT1)
		(ite NT7 NT25 NT1)
		(ite NT20 NT1 NT16)
		(ite NT21 NT14 NT1)
		(ite NT19 NT29 NT1)
		(ite NT21 NT9 NT9)
))
	(NT33  Int (		(ite NT17 NT25 NT1)
		(ite NT18 NT23 NT1)
		(+ NT26 NT1)
		(ite NT21 NT16 NT1)
		(ite NT21 NT12 NT12)
		(ite NT43 NT22 NT1)
		(ite NT21 NT1 NT16)
		(ite NT20 NT10 NT10)
		(ite NT7 NT24 NT1)
		(ite NT3 NT32 NT1)
		(ite NT43 NT1 NT22)
		(- NT26 NT1)
		(ite NT19 NT30 NT1)
		(ite NT53 NT1 NT1)
		(ite NT8 NT31 NT1)
		(ite NT20 NT29 NT1)
		(ite NT19 NT13 NT13)
))
	(NT34  Int (		(ite NT19 NT31 NT1)
		(ite NT7 NT26 NT1)
		(ite NT20 NT13 NT13)
		(ite NT43 NT23 NT1)
		(ite NT44 NT1 NT22)
		(- NT27 NT1)
		(+ NT27 NT1)
		(ite NT54 NT1 NT1)
		(ite NT43 NT1 NT23)
		(ite NT21 NT29 NT1)
		(ite NT17 NT24 NT1)
		(ite NT19 NT11 NT11)
		(ite NT21 NT10 NT10)
		(ite NT44 NT22 NT1)
		(ite NT20 NT30 NT1)
		(ite NT3 NT33 NT1)
		(ite NT8 NT32 NT1)
		(ite NT18 NT25 NT1)
))
	(NT35  Int (		(ite NT19 NT32 NT1)
		(+ NT28 NT1)
		(ite NT48 NT1 NT29)
		(ite NT20 NT31 NT1)
		(ite NT19 NT14 NT14)
		(ite NT45 NT1 NT22)
		(ite NT20 NT11 NT11)
		(ite NT8 NT33 NT1)
		(ite NT43 NT1 NT25)
		(ite NT55 NT1 NT1)
		(ite NT3 NT34 NT1)
		(ite NT44 NT23 NT1)
		(ite NT7 NT27 NT1)
		(ite NT44 NT1 NT23)
		(ite NT48 NT29 NT1)
		(ite NT18 NT24 NT1)
		(ite NT21 NT13 NT13)
		(ite NT43 NT25 NT1)
		(ite NT21 NT30 NT1)
		(ite NT17 NT26 NT1)
		(- NT28 NT1)
		(ite NT45 NT22 NT1)
))
	(NT36  Int (		(ite NT43 NT32 NT1)
		(ite NT19 NT27 NT1)
		(ite NT45 NT1 NT30)
		(+ NT29 NT29)
		(ite NT3 NT40 NT1)
		(ite NT45 NT30 NT1)
		(ite NT43 NT1 NT32)
		(ite NT46 NT29 NT1)
		(ite NT77 NT1 NT1)
		(ite NT48 NT25 NT1)
		(- NT38 NT1)
		(ite NT21 NT24 NT1)
		(ite NT18 NT15 NT15)
		(ite NT46 NT1 NT29)
		(ite NT18 NT33 NT1)
		(+ NT38 NT1)
		(ite NT48 NT1 NT25)
		(- NT29 NT29)
		(ite NT49 NT1 NT23)
		(ite NT20 NT26 NT1)
		(ite NT49 NT23 NT1)
		(ite NT44 NT31 NT1)
		(ite NT50 NT22 NT1)
		(ite NT17 NT34 NT1)
		(ite NT7 NT35 NT1)
		(ite NT50 NT1 NT22)
		(ite NT44 NT1 NT31)
		(ite NT17 NT16 NT16)
		(ite NT8 NT28 NT1)
))
	(NT37  Int (		(ite NT44 NT24 NT1)
		(ite NT48 NT1 NT31)
		(ite NT17 NT28 NT1)
		(ite NT19 NT34 NT1)
		(ite NT20 NT15 NT15)
		(ite NT46 NT1 NT23)
		(ite NT50 NT29 NT1)
		(ite NT50 NT1 NT29)
		(ite NT3 NT38 NT1)
		(ite NT46 NT23 NT1)
		(ite NT86 NT1 NT1)
		(ite NT18 NT27 NT1)
		(ite NT21 NT32 NT1)
		(ite NT8 NT35 NT1)
		(ite NT43 NT1 NT26)
		(ite NT43 NT26 NT1)
		(- NT36 NT1)
		(ite NT45 NT1 NT25)
		(ite NT45 NT25 NT1)
		(ite NT48 NT31 NT1)
		(ite NT44 NT1 NT24)
		(ite NT7 NT40 NT1)
		(+ NT36 NT1)
		(ite NT19 NT16 NT16)
		(ite NT21 NT14 NT14)
		(ite NT49 NT30 NT1)
		(ite NT49 NT1 NT30)
		(ite NT20 NT33 NT1)
))
	(NT38  Int (		(ite NT3 NT35 NT1)
		(ite NT19 NT15 NT15)
		(ite NT49 NT1 NT29)
		(ite NT18 NT26 NT1)
		(ite NT43 NT1 NT24)
		(ite NT45 NT23 NT1)
		(ite NT7 NT28 NT1)
		(ite NT8 NT34 NT1)
		(ite NT17 NT27 NT1)
		(ite NT84 NT1 NT1)
		(+ NT40 NT1)
		(ite NT43 NT24 NT1)
		(ite NT21 NT11 NT11)
		(ite NT46 NT22 NT1)
		(ite NT49 NT29 NT1)
		(- NT40 NT1)
		(ite NT20 NT14 NT14)
		(ite NT48 NT1 NT30)
		(ite NT44 NT1 NT25)
		(ite NT19 NT33 NT1)
		(ite NT48 NT30 NT1)
		(ite NT20 NT32 NT1)
		(ite NT46 NT1 NT22)
		(ite NT45 NT1 NT23)
		(ite NT44 NT25 NT1)
		(ite NT21 NT31 NT1)
))
	(NT39  Int (		(ite NT17 NT40 NT1)
		(ite NT46 NT1 NT25)
		(ite NT47 NT22 NT1)
		(ite NT21 NT15 NT15)
		(ite NT44 NT26 NT1)
		(ite NT50 NT30 NT1)
		(ite NT85 NT1 NT1)
		(ite NT45 NT1 NT24)
		(ite NT47 NT1 NT22)
		(ite NT7 NT36 NT1)
		(ite NT52 NT29 NT1)
		(ite NT18 NT28 NT1)
		(ite NT19 NT35 NT1)
		(ite NT20 NT16 NT16)
		(+ NT41 NT1)
		(ite NT48 NT32 NT1)
		(- NT41 NT1)
		(ite NT49 NT31 NT1)
		(ite NT50 NT1 NT30)
		(ite NT44 NT1 NT26)
		(ite NT52 NT1 NT29)
		(ite NT48 NT1 NT32)
		(ite NT46 NT25 NT1)
		(ite NT43 NT27 NT1)
		(ite NT45 NT24 NT1)
		(ite NT49 NT1 NT31)
		(ite NT43 NT1 NT27)
		(ite NT3 NT37 NT1)
		(ite NT20 NT34 NT1)
		(ite NT21 NT33 NT1)
		(ite NT8 NT38 NT1)
))
	(NT40  Int (		(+ NT22 NT22)
		(- NT22 NT22)
		(ite NT21 NT25 NT1)
		(ite NT44 NT30 NT1)
		(ite NT43 NT31 NT1)
		(+ NT35 NT1)
		(ite NT3 NT28 NT1)
		(ite NT8 NT27 NT1)
		(ite NT48 NT23 NT1)
		(ite NT18 NT14 NT14)
		(ite NT43 NT1 NT31)
		(ite NT20 NT24 NT1)
		(ite NT49 NT1 NT22)
		(ite NT49 NT22 NT1)
		(ite NT48 NT1 NT23)
		(ite NT76 NT1 NT1)
		(ite NT17 NT33 NT1)
		(ite NT44 NT1 NT30)
		(ite NT19 NT26 NT1)
		(- NT35 NT1)
		(ite NT7 NT34 NT1)
		(ite NT18 NT32 NT1)
		(ite NT45 NT29 NT1)
		(ite NT45 NT1 NT29)
		(ite NT17 NT15 NT15)
))
	(NT41  Int (		(ite NT17 NT35 NT1)
		(ite NT50 NT23 NT1)
		(ite NT52 NT1 NT22)
		(ite NT18 NT34 NT1)
		(ite NT45 NT1 NT31)
		(ite NT46 NT30 NT1)
		(ite NT45 NT31 NT1)
		(ite NT46 NT1 NT30)
		(ite NT3 NT36 NT1)
		(ite NT50 NT1 NT23)
		(ite NT19 NT28 NT1)
		(ite NT52 NT22 NT1)
		(ite NT43 NT1 NT33)
		(ite NT18 NT16 NT16)
		(ite NT49 NT1 NT25)
		(ite NT49 NT25 NT1)
		(ite NT44 NT32 NT1)
		(+ NT37 NT1)
		(ite NT43 NT33 NT1)
		(- NT23 NT23)
		(ite NT44 NT1 NT32)
		(ite NT48 NT24 NT1)
		(ite NT21 NT26 NT1)
		(ite NT79 NT1 NT1)
		(- NT37 NT1)
		(+ NT23 NT23)
		(ite NT20 NT27 NT1)
		(ite NT7 NT38 NT1)
		(ite NT48 NT1 NT24)
		(ite NT8 NT40 NT1)
))
	(NT42  Int (		(ite NT51 NT29 NT1)
		(ite NT52 NT30 NT1)
		(ite NT45 NT1 NT26)
		(ite NT7 NT41 NT1)
		(ite NT51 NT1 NT29)
		(ite NT49 NT32 NT1)
		(ite NT17 NT36 NT1)
		(ite NT47 NT23 NT1)
		(ite NT18 NT40 NT1)
		(ite NT46 NT24 NT1)
		(ite NT3 NT39 NT1)
		(ite NT43 NT28 NT1)
		(ite NT50 NT31 NT1)
		(ite NT49 NT1 NT32)
		(ite NT45 NT26 NT1)
		(ite NT43 NT1 NT28)
		(ite NT87 NT1 NT1)
		(ite NT21 NT34 NT1)
		(ite NT19 NT38 NT1)
		(ite NT8 NT37 NT1)
		(ite NT48 NT33 NT1)
		(ite NT48 NT1 NT33)
		(ite NT20 NT35 NT1)
		(ite NT21 NT16 NT16)
		(ite NT44 NT27 NT1)
		(ite NT52 NT1 NT30)
		(- NT56 NT1)
		(ite NT47 NT1 NT23)
		(ite NT50 NT1 NT31)
		(ite NT44 NT1 NT27)
		(+ NT56 NT1)
		(ite NT46 NT1 NT24)
))
	(NT43  Bool (		(or NT20 NT3)
		(= NT10 NT1)
		(or NT17 NT17)
		(>= NT10 NT1)
		(not NT43)
		(and NT17 NT17)
		(and NT20 NT3)
		(<= NT10 NT1)
))
	(NT44  Bool (		(not NT44)
		(or NT19 NT19)
		(and NT19 NT19)
		(= NT11 NT1)
		(or NT21 NT3)
		(<= NT11 NT1)
		(and NT21 NT3)
		(>= NT11 NT1)
))
	(NT45  Bool (		(or NT18 NT18)
		(and NT48 NT3)
		(<= NT15 NT1)
		(= NT15 NT1)
		(>= NT15 NT1)
		(and NT18 NT18)
		(not NT45)
		(or NT48 NT3)
))
	(NT46  Bool (		(= NT22 NT1)
		(<= NT22 NT1)
		(or NT49 NT3)
		(or NT20 NT20)
		(not NT46)
		(>= NT22 NT1)
		(and NT20 NT20)
		(and NT49 NT3)
))
	(NT47  Bool (		(not NT47)
		(and NT52 NT3)
		(<= NT25 NT1)
		(= NT25 NT1)
		(or NT52 NT3)
		(>= NT25 NT1)
		(or NT21 NT21)
		(and NT21 NT21)
))
	(NT48  Bool (		(<= NT9 NT9)
		(not NT48)
		(or NT44 NT3)
		(= NT9 NT9)
		(and NT44 NT3)
		(>= NT14 NT1)
		(<= NT14 NT1)
		(>= NT9 NT9)
		(= NT14 NT1)
))
	(NT49  Bool (		(<= NT16 NT1)
		(or NT45 NT3)
		(<= NT12 NT12)
		(= NT16 NT1)
		(and NT45 NT3)
		(not NT49)
		(>= NT12 NT12)
		(= NT12 NT12)
		(>= NT16 NT1)
))
	(NT50  Bool (		(not NT50)
		(>= NT29 NT1)
		(= NT29 NT1)
		(and NT46 NT3)
		(= NT10 NT10)
		(<= NT29 NT1)
		(<= NT10 NT10)
		(>= NT10 NT10)
		(or NT46 NT3)
))
	(NT51  Bool (		(>= NT11 NT11)
		(<= NT11 NT11)
		(= NT31 NT1)
		(>= NT31 NT1)
		(or NT47 NT3)
		(and NT47 NT3)
		(<= NT31 NT1)
		(= NT11 NT11)
		(not NT51)
))
	(NT52  Bool (		(= NT30 NT1)
		(or NT72 NT3)
		(>= NT30 NT1)
		(>= NT13 NT13)
		(and NT72 NT3)
		(<= NT13 NT13)
		(<= NT30 NT1)
		(= NT13 NT13)
		(not NT52)
))
	(NT53  Bool (		(>= NT32 NT1)
		(<= NT14 NT14)
		(or NT73 NT3)
		(= NT14 NT14)
		(and NT73 NT3)
		(= NT32 NT1)
		(not NT53)
		(<= NT32 NT1)
		(>= NT14 NT14)
))
	(NT54  Bool (		(<= NT15 NT15)
		(or NT74 NT3)
		(not NT54)
		(>= NT33 NT1)
		(and NT74 NT3)
		(= NT33 NT1)
		(>= NT15 NT15)
		(<= NT33 NT1)
		(= NT15 NT15)
))
	(NT55  Bool (		(= NT34 NT1)
		(>= NT16 NT16)
		(<= NT16 NT16)
		(or NT75 NT3)
		(not NT55)
		(<= NT34 NT1)
		(>= NT34 NT1)
		(and NT75 NT3)
		(= NT16 NT16)
))
	(NT56  Int (		(ite NT44 NT1 NT33)
		(ite NT50 NT25 NT1)
		(ite NT17 NT38 NT1)
		(ite NT43 NT1 NT34)
		(ite NT45 NT32 NT1)
		(+ NT30 NT30)
		(ite NT48 NT26 NT1)
		(ite NT47 NT1 NT29)
		(ite NT3 NT41 NT1)
		(ite NT52 NT1 NT23)
		(ite NT49 NT1 NT24)
		(ite NT51 NT1 NT22)
		(ite NT46 NT1 NT31)
		(ite NT20 NT28 NT1)
		(ite NT51 NT22 NT1)
		(ite NT47 NT29 NT1)
		(- NT39 NT1)
		(ite NT49 NT24 NT1)
		(ite NT45 NT1 NT32)
		(ite NT43 NT34 NT1)
		(ite NT8 NT36 NT1)
		(ite NT48 NT1 NT26)
		(ite NT7 NT37 NT1)
		(ite NT88 NT1 NT1)
		(ite NT21 NT27 NT1)
		(ite NT46 NT31 NT1)
		(+ NT39 NT1)
		(ite NT18 NT35 NT1)
		(ite NT52 NT23 NT1)
		(- NT30 NT30)
		(ite NT19 NT40 NT1)
		(ite NT44 NT33 NT1)
		(ite NT50 NT1 NT25)
))
	(NT57  Int (		(ite NT44 NT34 NT1)
		(ite NT48 NT1 NT27)
		(ite NT47 NT30 NT1)
		(ite NT3 NT56 NT1)
		(- NT25 NT25)
		(ite NT45 NT1 NT33)
		(+ NT42 NT1)
		(ite NT18 NT38 NT1)
		(ite NT53 NT22 NT1)
		(ite NT46 NT32 NT1)
		(ite NT45 NT33 NT1)
		(ite NT81 NT1 NT1)
		(ite NT43 NT35 NT1)
		(ite NT44 NT1 NT34)
		(ite NT20 NT40 NT1)
		(ite NT19 NT36 NT1)
		(ite NT17 NT37 NT1)
		(ite NT51 NT1 NT23)
		(ite NT8 NT41 NT1)
		(ite NT43 NT22 NT22)
		(ite NT52 NT1 NT25)
		(- NT42 NT1)
		(ite NT21 NT28 NT1)
		(ite NT52 NT25 NT1)
		(ite NT47 NT1 NT30)
		(ite NT49 NT1 NT26)
		(ite NT51 NT23 NT1)
		(ite NT48 NT27 NT1)
		(+ NT25 NT25)
		(ite NT50 NT24 NT1)
		(ite NT46 NT1 NT32)
		(ite NT49 NT26 NT1)
		(ite NT7 NT39 NT1)
		(ite NT53 NT1 NT22)
		(ite NT43 NT1 NT35)
		(ite NT50 NT1 NT24)
))
	(NT58  Int (		(+ NT66 NT1)
		(ite NT52 NT26 NT1)
		(- NT24 NT24)
		(ite NT43 NT1 NT37)
		(ite NT44 NT29 NT29)
		(ite NT48 NT40 NT1)
		(ite NT20 NT41 NT1)
		(ite NT21 NT36 NT1)
		(ite NT44 NT38 NT1)
		(ite NT43 NT23 NT23)
		(ite NT54 NT1 NT23)
		(ite NT51 NT1 NT24)
		(ite NT44 NT1 NT38)
		(ite NT45 NT1 NT35)
		(ite NT19 NT56 NT1)
		(ite NT52 NT1 NT26)
		(ite NT51 NT24 NT1)
		(ite NT50 NT1 NT27)
		(ite NT7 NT65 NT1)
		(ite NT49 NT1 NT28)
		(ite NT46 NT34 NT1)
		(ite NT43 NT37 NT1)
		(ite NT53 NT1 NT25)
		(ite NT45 NT22 NT22)
		(+ NT24 NT24)
		(ite NT3 NT61 NT1)
		(ite NT8 NT57 NT1)
		(ite NT49 NT28 NT1)
		(ite NT55 NT1 NT22)
		(ite NT17 NT42 NT1)
		(ite NT54 NT23 NT1)
		(ite NT80 NT1 NT1)
		(ite NT46 NT1 NT34)
		(ite NT18 NT39 NT1)
		(ite NT48 NT1 NT40)
		(ite NT47 NT32 NT1)
		(ite NT53 NT25 NT1)
		(ite NT50 NT27 NT1)
		(- NT66 NT1)
		(ite NT45 NT35 NT1)
		(ite NT47 NT1 NT32)
		(ite NT55 NT22 NT1)
))
	(NT59  Int (		(ite NT45 NT37 NT1)
		(ite NT55 NT1 NT25)
		(- NT26 NT26)
		(ite NT45 NT23 NT23)
		(ite NT46 NT38 NT1)
		(ite NT18 NT65 NT1)
		(ite NT21 NT56 NT1)
		(ite NT43 NT25 NT25)
		(ite NT55 NT25 NT1)
		(ite NT43 NT1 NT42)
		(+ NT68 NT1)
		(ite NT20 NT57 NT1)
		(ite NT82 NT1 NT1)
		(ite NT54 NT1 NT24)
		(ite NT51 NT1 NT27)
		(ite NT53 NT1 NT26)
		(ite NT7 NT67 NT1)
		(ite NT49 NT36 NT1)
		(ite NT45 NT1 NT37)
		(ite NT17 NT66 NT1)
		(ite NT46 NT1 NT38)
		(ite NT19 NT61 NT1)
		(ite NT43 NT42 NT1)
		(ite NT52 NT28 NT1)
		(ite NT50 NT1 NT40)
		(ite NT48 NT1 NT41)
		(+ NT26 NT26)
		(- NT68 NT1)
		(ite NT44 NT30 NT30)
		(ite NT3 NT62 NT1)
		(ite NT49 NT1 NT36)
		(ite NT46 NT29 NT29)
		(ite NT44 NT39 NT1)
		(ite NT51 NT27 NT1)
		(ite NT47 NT1 NT34)
		(ite NT47 NT34 NT1)
		(ite NT48 NT41 NT1)
		(ite NT44 NT1 NT39)
		(ite NT8 NT58 NT1)
		(ite NT53 NT26 NT1)
		(ite NT50 NT40 NT1)
		(ite NT54 NT24 NT1)
		(ite NT52 NT1 NT28)
))
	(NT60  Int (		(+ NT70 NT1)
		(ite NT21 NT61 NT1)
		(ite NT20 NT58 NT1)
		(- NT70 NT1)
		(ite NT3 NT63 NT1)
		(ite NT52 NT1 NT36)
		(+ NT27 NT27)
		(ite NT83 NT1 NT1)
		(ite NT8 NT59 NT1)
		(ite NT54 NT27 NT1)
		(ite NT50 NT41 NT1)
		(ite NT46 NT1 NT39)
		(ite NT43 NT24 NT24)
		(ite NT54 NT1 NT27)
		(ite NT47 NT38 NT1)
		(ite NT19 NT62 NT1)
		(ite NT55 NT1 NT26)
		(ite NT53 NT28 NT1)
		(ite NT44 NT65 NT1)
		(ite NT7 NT69 NT1)
		(ite NT45 NT42 NT1)
		(ite NT43 NT66 NT1)
		(ite NT49 NT56 NT1)
		(ite NT18 NT67 NT1)
		(ite NT51 NT1 NT40)
		(ite NT44 NT31 NT31)
		(ite NT47 NT29 NT29)
		(ite NT47 NT1 NT38)
		(ite NT52 NT36 NT1)
		(ite NT46 NT39 NT1)
		(ite NT46 NT30 NT30)
		(ite NT17 NT68 NT1)
		(- NT27 NT27)
		(ite NT55 NT26 NT1)
		(ite NT48 NT57 NT1)
		(ite NT45 NT25 NT25)
		(ite NT45 NT1 NT42)
		(ite NT53 NT1 NT28)
		(ite NT50 NT1 NT41)
		(ite NT51 NT40 NT1)
))
	(NT61  Int (		(ite NT8 NT56 NT1)
		(ite NT50 NT26 NT1)
		(ite NT43 NT29 NT29)
		(ite NT49 NT1 NT27)
		(ite NT46 NT1 NT33)
		(+ NT65 NT1)
		(- NT65 NT1)
		(ite NT45 NT34 NT1)
		(ite NT48 NT28 NT1)
		(ite NT20 NT36 NT1)
		(ite NT43 NT1 NT38)
		(ite NT54 NT22 NT1)
		(ite NT53 NT1 NT23)
		(ite NT50 NT1 NT26)
		(ite NT49 NT27 NT1)
		(+ NT31 NT31)
		(- NT31 NT31)
		(ite NT78 NT1 NT1)
		(ite NT17 NT39 NT1)
		(ite NT52 NT24 NT1)
		(ite NT43 NT38 NT1)
		(ite NT18 NT37 NT1)
		(ite NT44 NT1 NT35)
		(ite NT44 NT35 NT1)
		(ite NT45 NT1 NT34)
		(ite NT44 NT22 NT22)
		(ite NT54 NT1 NT22)
		(ite NT51 NT25 NT1)
		(ite NT53 NT23 NT1)
		(ite NT19 NT41 NT1)
		(ite NT21 NT40 NT1)
		(ite NT48 NT1 NT28)
		(ite NT47 NT31 NT1)
		(ite NT51 NT1 NT25)
		(ite NT52 NT1 NT24)
		(ite NT3 NT57 NT1)
		(ite NT7 NT42 NT1)
		(ite NT46 NT33 NT1)
		(ite NT47 NT1 NT31)
))
	(NT62  Int (		(ite NT51 NT26 NT1)
		(ite NT45 NT38 NT1)
		(ite NT46 NT1 NT35)
		(ite NT44 NT1 NT37)
		(ite NT46 NT22 NT22)
		(ite NT18 NT42 NT1)
		(ite NT44 NT37 NT1)
		(ite NT43 NT1 NT39)
		(ite NT49 NT40 NT1)
		(ite NT7 NT66 NT1)
		(ite NT48 NT36 NT1)
		(ite NT52 NT27 NT1)
		(ite NT21 NT41 NT1)
		(ite NT43 NT39 NT1)
		(+ NT67 NT1)
		(ite NT17 NT65 NT1)
		(ite NT53 NT1 NT24)
		(+ NT32 NT32)
		(ite NT45 NT29 NT29)
		(ite NT20 NT56 NT1)
		(ite NT47 NT33 NT1)
		(ite NT51 NT1 NT26)
		(ite NT46 NT35 NT1)
		(ite NT8 NT61 NT1)
		(ite NT97 NT1 NT1)
		(ite NT45 NT1 NT38)
		(ite NT52 NT1 NT27)
		(ite NT50 NT1 NT28)
		(ite NT44 NT23 NT23)
		(ite NT48 NT1 NT36)
		(ite NT55 NT1 NT23)
		(ite NT19 NT57 NT1)
		(ite NT55 NT23 NT1)
		(ite NT49 NT1 NT40)
		(ite NT47 NT1 NT33)
		(- NT32 NT32)
		(ite NT54 NT25 NT1)
		(ite NT50 NT28 NT1)
		(ite NT54 NT1 NT25)
		(- NT67 NT1)
		(ite NT43 NT30 NT30)
		(ite NT53 NT24 NT1)
		(ite NT3 NT58 NT1)
))
	(NT63  Int (		(ite NT49 NT1 NT41)
		(ite NT44 NT25 NT25)
		(ite NT43 NT65 NT1)
		(ite NT8 NT62 NT1)
		(ite NT46 NT1 NT37)
		(ite NT17 NT67 NT1)
		(ite NT18 NT66 NT1)
		(ite NT54 NT26 NT1)
		(ite NT44 NT42 NT1)
		(- NT33 NT33)
		(ite NT50 NT36 NT1)
		(ite NT45 NT1 NT39)
		(ite NT55 NT1 NT24)
		(ite NT52 NT40 NT1)
		(ite NT47 NT22 NT22)
		(ite NT43 NT31 NT31)
		(ite NT49 NT41 NT1)
		(ite NT47 NT1 NT35)
		(ite NT7 NT68 NT1)
		(ite NT19 NT58 NT1)
		(ite NT46 NT23 NT23)
		(ite NT51 NT1 NT28)
		(ite NT52 NT1 NT40)
		(ite NT44 NT1 NT42)
		(+ NT33 NT33)
		(ite NT54 NT1 NT26)
		(+ NT69 NT1)
		(ite NT50 NT1 NT36)
		(ite NT20 NT61 NT1)
		(ite NT21 NT57 NT1)
		(ite NT45 NT39 NT1)
		(ite NT55 NT24 NT1)
		(- NT69 NT1)
		(ite NT53 NT27 NT1)
		(ite NT47 NT35 NT1)
		(ite NT53 NT1 NT27)
		(ite NT46 NT37 NT1)
		(ite NT51 NT28 NT1)
		(ite NT98 NT1 NT1)
		(ite NT3 NT59 NT1)
		(ite NT45 NT30 NT30)
		(ite NT48 NT56 NT1)
))
	(NT64  Int (		(ite NT45 NT31 NT31)
		(ite NT50 NT56 NT1)
		(ite NT47 NT23 NT23)
		(ite NT46 NT25 NT25)
		(ite NT52 NT41 NT1)
		(ite NT44 NT66 NT1)
		(ite NT46 NT1 NT42)
		(ite NT44 NT24 NT24)
		(- NT71 NT1)
		(ite NT52 NT1 NT41)
		(ite NT49 NT57 NT1)
		(ite NT99 NT1 NT1)
		(ite NT54 NT28 NT1)
		(ite NT55 NT27 NT1)
		(ite NT8 NT63 NT1)
		(ite NT3 NT60 NT1)
		(ite NT46 NT42 NT1)
		(ite NT53 NT40 NT1)
		(ite NT53 NT1 NT40)
		(ite NT43 NT32 NT32)
		(ite NT47 NT1 NT37)
		(ite NT47 NT37 NT1)
		(ite NT48 NT61 NT1)
		(ite NT7 NT70 NT1)
		(ite NT18 NT68 NT1)
		(ite NT55 NT1 NT27)
		(ite NT45 NT65 NT1)
		(ite NT51 NT36 NT1)
		(- NT34 NT34)
		(ite NT19 NT59 NT1)
		(+ NT71 NT1)
		(ite NT54 NT1 NT28)
		(ite NT20 NT62 NT1)
		(ite NT17 NT69 NT1)
		(ite NT43 NT67 NT1)
		(+ NT34 NT34)
		(ite NT21 NT58 NT1)
		(ite NT51 NT1 NT36)
))
	(NT65  Int (		(ite NT19 NT37 NT1)
		(ite NT48 NT1 NT34)
		(ite NT47 NT1 NT25)
		(ite NT46 NT26 NT1)
		(ite NT47 NT25 NT1)
		(- NT57 NT1)
		(ite NT50 NT1 NT32)
		(ite NT51 NT30 NT1)
		(ite NT89 NT1 NT1)
		(ite NT52 NT1 NT31)
		(ite NT53 NT1 NT29)
		(ite NT43 NT40 NT1)
		(ite NT50 NT32 NT1)
		(ite NT8 NT39 NT1)
		(ite NT43 NT1 NT40)
		(ite NT17 NT41 NT1)
		(ite NT51 NT1 NT30)
		(ite NT45 NT1 NT27)
		(ite NT49 NT1 NT33)
		(ite NT3 NT42 NT1)
		(ite NT49 NT33 NT1)
		(ite NT20 NT38 NT1)
		(ite NT45 NT27 NT1)
		(ite NT7 NT56 NT1)
		(ite NT44 NT28 NT1)
		(+ NT57 NT1)
		(ite NT53 NT29 NT1)
		(ite NT46 NT1 NT26)
		(ite NT48 NT34 NT1)
		(ite NT21 NT35 NT1)
		(ite NT18 NT36 NT1)
		(ite NT52 NT31 NT1)
		(ite NT44 NT1 NT28)
))
	(NT66  Int (		(ite NT45 NT28 NT1)
		(- NT61 NT1)
		(ite NT18 NT41 NT1)
		(ite NT49 NT1 NT34)
		(ite NT46 NT1 NT27)
		(ite NT43 NT1 NT36)
		(ite NT7 NT57 NT1)
		(ite NT48 NT22 NT22)
		(ite NT8 NT42 NT1)
		(ite NT53 NT30 NT1)
		(+ NT61 NT1)
		(ite NT43 NT36 NT1)
		(ite NT49 NT34 NT1)
		(ite NT44 NT40 NT1)
		(ite NT53 NT1 NT30)
		(ite NT20 NT37 NT1)
		(ite NT17 NT56 NT1)
		(ite NT19 NT39 NT1)
		(ite NT47 NT1 NT24)
		(ite NT48 NT1 NT35)
		(ite NT46 NT27 NT1)
		(ite NT93 NT1 NT1)
		(ite NT50 NT1 NT33)
		(ite NT50 NT33 NT1)
		(ite NT45 NT1 NT28)
		(ite NT52 NT1 NT32)
		(ite NT52 NT32 NT1)
		(ite NT54 NT29 NT1)
		(ite NT3 NT65 NT1)
		(ite NT44 NT1 NT40)
		(ite NT21 NT38 NT1)
		(ite NT48 NT35 NT1)
		(ite NT51 NT1 NT31)
		(ite NT47 NT24 NT1)
		(ite NT51 NT31 NT1)
		(ite NT54 NT1 NT29)
))
	(NT67  Int (		(ite NT54 NT1 NT30)
		(ite NT17 NT57 NT1)
		(ite NT55 NT1 NT29)
		(ite NT53 NT31 NT1)
		(ite NT49 NT1 NT35)
		(ite NT49 NT22 NT22)
		(ite NT52 NT1 NT33)
		(ite NT7 NT61 NT1)
		(ite NT48 NT29 NT29)
		(+ NT58 NT1)
		(ite NT48 NT38 NT1)
		(ite NT50 NT34 NT1)
		(ite NT46 NT28 NT1)
		(ite NT47 NT26 NT1)
		(ite NT51 NT32 NT1)
		(ite NT8 NT65 NT1)
		(ite NT45 NT1 NT40)
		(ite NT46 NT1 NT28)
		(ite NT3 NT66 NT1)
		(ite NT49 NT35 NT1)
		(ite NT90 NT1 NT1)
		(ite NT43 NT41 NT1)
		(ite NT45 NT40 NT1)
		(ite NT48 NT1 NT38)
		(ite NT55 NT29 NT1)
		(ite NT51 NT1 NT32)
		(ite NT18 NT56 NT1)
		(ite NT52 NT33 NT1)
		(ite NT44 NT1 NT36)
		(ite NT47 NT1 NT26)
		(ite NT53 NT1 NT31)
		(ite NT20 NT39 NT1)
		(ite NT50 NT1 NT34)
		(ite NT44 NT36 NT1)
		(ite NT43 NT1 NT41)
		(- NT58 NT1)
		(ite NT21 NT37 NT1)
		(ite NT54 NT30 NT1)
		(ite NT19 NT42 NT1)
))
	(NT68  Int (		(ite NT45 NT36 NT1)
		(ite NT55 NT30 NT1)
		(ite NT44 NT1 NT41)
		(ite NT7 NT58 NT1)
		(ite NT46 NT40 NT1)
		(ite NT49 NT29 NT29)
		(ite NT8 NT66 NT1)
		(ite NT45 NT1 NT36)
		(ite NT52 NT34 NT1)
		(ite NT19 NT65 NT1)
		(ite NT3 NT67 NT1)
		(ite NT48 NT1 NT37)
		(ite NT94 NT1 NT1)
		(ite NT44 NT41 NT1)
		(ite NT52 NT1 NT34)
		(ite NT51 NT1 NT33)
		(ite NT50 NT1 NT35)
		(ite NT50 NT35 NT1)
		(ite NT55 NT1 NT30)
		(ite NT47 NT27 NT1)
		(ite NT20 NT42 NT1)
		(ite NT21 NT39 NT1)
		(ite NT17 NT61 NT1)
		(ite NT47 NT1 NT27)
		(+ NT62 NT1)
		(ite NT54 NT1 NT31)
		(ite NT53 NT32 NT1)
		(ite NT54 NT31 NT1)
		(- NT62 NT1)
		(ite NT18 NT57 NT1)
		(ite NT48 NT23 NT23)
		(ite NT49 NT38 NT1)
		(ite NT53 NT1 NT32)
		(ite NT51 NT33 NT1)
		(ite NT49 NT1 NT38)
		(ite NT50 NT22 NT22)
		(ite NT46 NT1 NT40)
		(ite NT48 NT37 NT1)
		(ite NT43 NT56 NT1)
))
	(NT69  Int (		(ite NT53 NT33 NT1)
		(ite NT48 NT39 NT1)
		(ite NT53 NT1 NT33)
		(ite NT17 NT58 NT1)
		(ite NT19 NT66 NT1)
		(ite NT52 NT1 NT35)
		(ite NT47 NT1 NT28)
		(+ NT59 NT1)
		(ite NT55 NT31 NT1)
		(ite NT91 NT1 NT1)
		(ite NT50 NT29 NT29)
		(ite NT45 NT1 NT41)
		(ite NT49 NT1 NT37)
		(ite NT21 NT42 NT1)
		(ite NT20 NT65 NT1)
		(ite NT8 NT67 NT1)
		(ite NT46 NT1 NT36)
		(ite NT50 NT38 NT1)
		(ite NT3 NT68 NT1)
		(ite NT55 NT1 NT31)
		(ite NT54 NT1 NT32)
		(ite NT51 NT34 NT1)
		(ite NT50 NT1 NT38)
		(- NT59 NT1)
		(ite NT18 NT61 NT1)
		(ite NT47 NT28 NT1)
		(ite NT44 NT56 NT1)
		(ite NT49 NT37 NT1)
		(ite NT49 NT23 NT23)
		(ite NT54 NT32 NT1)
		(ite NT48 NT30 NT30)
		(ite NT52 NT35 NT1)
		(ite NT45 NT41 NT1)
		(ite NT52 NT22 NT22)
		(ite NT7 NT62 NT1)
		(ite NT48 NT1 NT39)
		(ite NT46 NT36 NT1)
		(ite NT51 NT1 NT34)
		(ite NT43 NT57 NT1)
))
	(NT70  Int (		(ite NT51 NT1 NT35)
		(ite NT47 NT1 NT40)
		(- NT63 NT1)
		(ite NT50 NT23 NT23)
		(ite NT44 NT57 NT1)
		(ite NT3 NT69 NT1)
		(ite NT48 NT1 NT42)
		(ite NT20 NT66 NT1)
		(ite NT47 NT40 NT1)
		(ite NT21 NT65 NT1)
		(ite NT55 NT1 NT32)
		(ite NT19 NT67 NT1)
		(ite NT8 NT68 NT1)
		(ite NT51 NT22 NT22)
		(ite NT17 NT62 NT1)
		(ite NT52 NT38 NT1)
		(ite NT48 NT42 NT1)
		(ite NT53 NT34 NT1)
		(ite NT45 NT56 NT1)
		(ite NT49 NT39 NT1)
		(ite NT54 NT33 NT1)
		(ite NT50 NT1 NT37)
		(ite NT53 NT1 NT34)
		(+ NT63 NT1)
		(ite NT46 NT41 NT1)
		(ite NT43 NT61 NT1)
		(ite NT52 NT29 NT29)
		(ite NT51 NT35 NT1)
		(ite NT49 NT30 NT30)
		(ite NT18 NT58 NT1)
		(ite NT46 NT1 NT41)
		(ite NT7 NT59 NT1)
		(ite NT50 NT37 NT1)
		(ite NT52 NT1 NT38)
		(ite NT49 NT1 NT39)
		(ite NT95 NT1 NT1)
		(ite NT55 NT32 NT1)
		(ite NT54 NT1 NT33)
		(ite NT48 NT25 NT25)
))
	(NT71  Int (		(ite NT45 NT57 NT1)
		(ite NT7 NT63 NT1)
		(ite NT51 NT29 NT29)
		(ite NT52 NT37 NT1)
		(ite NT53 NT22 NT22)
		(ite NT50 NT30 NT30)
		(ite NT48 NT31 NT31)
		(- NT60 NT1)
		(ite NT50 NT1 NT39)
		(ite NT3 NT70 NT1)
		(ite NT21 NT66 NT1)
		(ite NT50 NT39 NT1)
		(ite NT17 NT59 NT1)
		(ite NT8 NT69 NT1)
		(ite NT48 NT65 NT1)
		(ite NT44 NT61 NT1)
		(ite NT53 NT1 NT35)
		(ite NT47 NT1 NT36)
		(ite NT49 NT1 NT42)
		(ite NT52 NT1 NT37)
		(ite NT46 NT56 NT1)
		(ite NT43 NT58 NT1)
		(ite NT20 NT67 NT1)
		(ite NT53 NT35 NT1)
		(ite NT54 NT34 NT1)
		(ite NT49 NT25 NT25)
		(ite NT55 NT33 NT1)
		(ite NT55 NT1 NT33)
		(ite NT51 NT1 NT38)
		(ite NT51 NT38 NT1)
		(+ NT60 NT1)
		(ite NT54 NT1 NT34)
		(ite NT92 NT1 NT1)
		(ite NT52 NT23 NT23)
		(ite NT18 NT62 NT1)
		(ite NT49 NT42 NT1)
		(ite NT19 NT68 NT1)
		(ite NT47 NT36 NT1)
))
	(NT72  Bool (		(not NT72)
		(or NT43 NT43)
		(and NT43 NT43)
		(and NT50 NT3)
		(<= NT23 NT1)
		(or NT50 NT3)
		(>= NT23 NT1)
		(= NT23 NT1)
))
	(NT73  Bool (		(not NT73)
		(<= NT24 NT1)
		(or NT44 NT44)
		(and NT51 NT3)
		(or NT51 NT3)
		(>= NT24 NT1)
		(and NT44 NT44)
		(= NT24 NT1)
))
	(NT74  Bool (		(not NT74)
		(<= NT26 NT1)
		(and NT53 NT3)
		(or NT48 NT48)
		(= NT26 NT1)
		(>= NT26 NT1)
		(or NT53 NT3)
		(and NT48 NT48)
))
	(NT75  Bool (		(>= NT27 NT1)
		(or NT54 NT3)
		(and NT45 NT45)
		(<= NT27 NT1)
		(and NT54 NT3)
		(not NT75)
		(or NT45 NT45)
		(= NT27 NT1)
))
	(NT76  Bool (		(= NT28 NT1)
		(and NT55 NT3)
		(or NT49 NT49)
		(or NT55 NT3)
		(<= NT28 NT1)
		(and NT49 NT49)
		(>= NT28 NT1)
		(not NT76)
))
	(NT77  Bool (		(or NT46 NT46)
		(and NT46 NT46)
		(>= NT40 NT1)
		(or NT84 NT3)
		(and NT84 NT3)
		(= NT40 NT1)
		(<= NT40 NT1)
		(not NT77)
))
	(NT78  Bool (		(<= NT57 NT1)
		(= NT57 NT1)
		(>= NT57 NT1)
		(or NT89 NT3)
		(or NT47 NT47)
		(and NT47 NT47)
		(not NT78)
		(and NT89 NT3)
))
	(NT79  Bool (		(or NT50 NT50)
		(or NT86 NT3)
		(and NT50 NT50)
		(= NT36 NT1)
		(>= NT36 NT1)
		(and NT86 NT3)
		(not NT79)
		(<= NT36 NT1)
))
	(NT80  Bool (		(and NT93 NT3)
		(and NT51 NT51)
		(or NT93 NT3)
		(not NT80)
		(or NT51 NT51)
		(>= NT61 NT1)
		(= NT61 NT1)
		(<= NT61 NT1)
))
	(NT81  Bool (		(or NT52 NT52)
		(not NT81)
		(and NT52 NT52)
		(= NT56 NT1)
		(and NT87 NT3)
		(<= NT56 NT1)
		(>= NT56 NT1)
		(or NT87 NT3)
))
	(NT82  Bool (		(or NT53 NT53)
		(= NT62 NT1)
		(and NT94 NT3)
		(and NT53 NT53)
		(<= NT62 NT1)
		(>= NT62 NT1)
		(not NT82)
		(or NT94 NT3)
))
	(NT83  Bool (		(<= NT63 NT1)
		(>= NT63 NT1)
		(and NT54 NT54)
		(or NT54 NT54)
		(= NT63 NT1)
		(not NT83)
		(and NT95 NT3)
		(or NT95 NT3)
))
	(NT84  Bool (		(>= NT35 NT1)
		(and NT76 NT3)
		(>= NT22 NT22)
		(= NT22 NT22)
		(or NT76 NT3)
		(= NT35 NT1)
		(<= NT35 NT1)
		(<= NT22 NT22)
		(not NT84)
))
	(NT85  Bool (		(>= NT37 NT1)
		(not NT85)
		(<= NT23 NT23)
		(= NT37 NT1)
		(>= NT23 NT23)
		(and NT79 NT3)
		(= NT23 NT23)
		(<= NT37 NT1)
		(or NT79 NT3)
))
	(NT86  Bool (		(or NT77 NT3)
		(= NT38 NT1)
		(<= NT29 NT29)
		(>= NT29 NT29)
		(= NT29 NT29)
		(not NT86)
		(and NT77 NT3)
		(<= NT38 NT1)
		(>= NT38 NT1)
))
	(NT87  Bool (		(or NT88 NT3)
		(= NT30 NT30)
		(not NT87)
		(<= NT30 NT30)
		(= NT39 NT1)
		(>= NT30 NT30)
		(<= NT39 NT1)
		(and NT88 NT3)
		(>= NT39 NT1)
))
	(NT88  Bool (		(and NT72 NT72)
		(<= NT41 NT1)
		(= NT41 NT1)
		(not NT88)
		(and NT85 NT3)
		(or NT72 NT72)
		(or NT85 NT3)
		(>= NT41 NT1)
))
	(NT89  Bool (		(and NT81 NT3)
		(>= NT25 NT25)
		(= NT42 NT1)
		(= NT25 NT25)
		(or NT81 NT3)
		(>= NT42 NT1)
		(<= NT42 NT1)
		(<= NT25 NT25)
		(not NT89)
))
	(NT90  Bool (		(= NT24 NT24)
		(= NT66 NT1)
		(not NT90)
		(>= NT24 NT24)
		(<= NT66 NT1)
		(and NT80 NT3)
		(>= NT66 NT1)
		(<= NT24 NT24)
		(or NT80 NT3)
))
	(NT91  Bool (		(= NT68 NT1)
		(>= NT68 NT1)
		(not NT91)
		(<= NT68 NT1)
		(<= NT26 NT26)
		(>= NT26 NT26)
		(and NT82 NT3)
		(= NT26 NT26)
		(or NT82 NT3)
))
	(NT92  Bool (		(>= NT27 NT27)
		(= NT70 NT1)
		(= NT27 NT27)
		(not NT92)
		(<= NT70 NT1)
		(>= NT70 NT1)
		(or NT83 NT3)
		(<= NT27 NT27)
		(and NT83 NT3)
))
	(NT93  Bool (		(>= NT65 NT1)
		(or NT78 NT3)
		(<= NT65 NT1)
		(<= NT31 NT31)
		(not NT93)
		(= NT31 NT31)
		(and NT78 NT3)
		(>= NT31 NT31)
		(= NT65 NT1)
))
	(NT94  Bool (		(= NT67 NT1)
		(= NT32 NT32)
		(not NT94)
		(>= NT32 NT32)
		(>= NT67 NT1)
		(or NT97 NT3)
		(<= NT67 NT1)
		(and NT97 NT3)
		(<= NT32 NT32)
))
	(NT95  Bool (		(>= NT33 NT33)
		(= NT33 NT33)
		(<= NT33 NT33)
		(not NT95)
		(>= NT69 NT1)
		(and NT98 NT3)
		(or NT98 NT3)
		(<= NT69 NT1)
		(= NT69 NT1)
))
	(NT97  Bool (		(>= NT58 NT1)
		(or NT73 NT73)
		(<= NT58 NT1)
		(= NT58 NT1)
		(and NT73 NT73)
		(not NT97)
		(or NT90 NT3)
		(and NT90 NT3)
))
	(NT98  Bool (		(or NT74 NT74)
		(>= NT59 NT1)
		(not NT98)
		(and NT91 NT3)
		(= NT59 NT1)
		(<= NT59 NT1)
		(and NT74 NT74)
		(or NT91 NT3)
))
	(NT99  Bool (		(or NT92 NT3)
		(not NT99)
		(or NT75 NT75)
		(and NT75 NT75)
		(<= NT60 NT1)
		(and NT92 NT3)
		(= NT60 NT1)
		(>= NT60 NT1)
))
))
  ( define-fun and3  (      ( b1  Bool )  ( b2  Bool )  ( b3  Bool ) )  Bool  ( and     ( and     b1  b2 )  b3 ) )
  ( declare-var x  Int )
  ( declare-var y  Int )
  ( declare-var z  Int )
  ( constraint  ( =>     ( and3      ( =     x   38 )  ( =     y   11 )  ( =     z   35 ) )  ( =     ( eq1      x  y  z )   38 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   11 )  ( =     y   39 )  ( =     z   12 ) )  ( =     ( eq1      x  y  z )   11 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   3 )  ( =     y   30 )  ( =     z   7 ) )  ( =     ( eq1      x  y  z )   3 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   29 )  ( =     y   28 )  ( =     z   4 ) )  ( =     ( eq1      x  y  z )   4 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   2 )  ( =     y   37 )  ( =     z   45 ) )  ( =     ( eq1      x  y  z )   45 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   21 )  ( =     y   48 )  ( =     z   5 ) )  ( =     ( eq1      x  y  z )   5 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   23 )  ( =     y   8 )  ( =     z   10 ) )  ( =     ( eq1      x  y  z )   8 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   8 )  ( =     y   36 )  ( =     z   22 ) )  ( =     ( eq1      x  y  z )   36 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   24 )  ( =     y   16 )  ( =     z   6 ) )  ( =     ( eq1      x  y  z )   6 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   27 )  ( =     y   16 )  ( =     z   25 ) )  ( =     ( eq1      x  y  z )   27 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   11 )  ( =     y   6 )  ( =     z   37 ) )  ( =     ( eq1      x  y  z )   37 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   47 )  ( =     y   16 )  ( =     z   27 ) )  ( =     ( eq1      x  y  z )   16 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   10 )  ( =     y   21 )  ( =     z   7 ) )  ( =     ( eq1      x  y  z )   7 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   16 )  ( =     y   49 )  ( =     z   34 ) )  ( =     ( eq1      x  y  z )   49 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   19 )  ( =     y   3 )  ( =     z   22 ) )  ( =     ( eq1      x  y  z )   22 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   16 )  ( =     y   25 )  ( =     z   19 ) )  ( =     ( eq1      x  y  z )   25 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   20 )  ( =     y   49 )  ( =     z   27 ) )  ( =     ( eq1      x  y  z )   49 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   30 )  ( =     y   8 )  ( =     z   14 ) )  ( =     ( eq1      x  y  z )   8 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   1 )  ( =     y   31 )  ( =     z   29 ) )  ( =     ( eq1      x  y  z )   31 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   8 )  ( =     y   7 )  ( =     z   47 ) )  ( =     ( eq1      x  y  z )   47 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   32 )  ( =     y   19 )  ( =     z   4 ) )  ( =     ( eq1      x  y  z )   4 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   21 )  ( =     y   17 )  ( =     z   21 ) )  ( =     ( eq1      x  y  z )   21 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   47 )  ( =     y   26 )  ( =     z   41 ) )  ( =     ( eq1      x  y  z )   47 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   3 )  ( =     y   44 )  ( =     z   42 ) )  ( =     ( eq1      x  y  z )   44 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   39 )  ( =     y   14 )  ( =     z   44 ) )  ( =     ( eq1      x  y  z )   44 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   12 )  ( =     y   29 )  ( =     z   20 ) )  ( =     ( eq1      x  y  z )   29 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   31 )  ( =     y   49 )  ( =     z   18 ) )  ( =     ( eq1      x  y  z )   18 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   9 )  ( =     y   30 )  ( =     z   26 ) )  ( =     ( eq1      x  y  z )   30 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   22 )  ( =     y   30 )  ( =     z   6 ) )  ( =     ( eq1      x  y  z )   6 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   3 )  ( =     y   37 )  ( =     z   15 ) )  ( =     ( eq1      x  y  z )   37 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   1 )  ( =     y   21 )  ( =     z   35 ) )  ( =     ( eq1      x  y  z )   35 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   6 )  ( =     y   43 )  ( =     z   2 ) )  ( =     ( eq1      x  y  z )   2 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   26 )  ( =     y   39 )  ( =     z   29 ) )  ( =     ( eq1      x  y  z )   39 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   17 )  ( =     y   44 )  ( =     z   24 ) )  ( =     ( eq1      x  y  z )   44 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   8 )  ( =     y   32 )  ( =     z   38 ) )  ( =     ( eq1      x  y  z )   38 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   3 )  ( =     y   45 )  ( =     z   18 ) )  ( =     ( eq1      x  y  z )   45 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   22 )  ( =     y   25 )  ( =     z   16 ) )  ( =     ( eq1      x  y  z )   16 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   41 )  ( =     y   35 )  ( =     z   45 ) )  ( =     ( eq1      x  y  z )   45 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   16 )  ( =     y   9 )  ( =     z   26 ) )  ( =     ( eq1      x  y  z )   26 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   24 )  ( =     y   13 )  ( =     z   15 ) )  ( =     ( eq1      x  y  z )   13 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   40 )  ( =     y   15 )  ( =     z   37 ) )  ( =     ( eq1      x  y  z )   40 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   24 )  ( =     y   20 )  ( =     z   29 ) )  ( =     ( eq1      x  y  z )   29 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   27 )  ( =     y   45 )  ( =     z   17 ) )  ( =     ( eq1      x  y  z )   17 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   8 )  ( =     y   13 )  ( =     z   10 ) )  ( =     ( eq1      x  y  z )   13 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   31 )  ( =     y   22 )  ( =     z   43 ) )  ( =     ( eq1      x  y  z )   43 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   20 )  ( =     y   24 )  ( =     z   40 ) )  ( =     ( eq1      x  y  z )   40 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   38 )  ( =     y   47 )  ( =     z   14 ) )  ( =     ( eq1      x  y  z )   14 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   3 )  ( =     y   38 )  ( =     z   1 ) )  ( =     ( eq1      x  y  z )   1 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   50 )  ( =     y   5 )  ( =     z   9 ) )  ( =     ( eq1      x  y  z )   5 ) ) )
  ( constraint  ( =>     ( and3      ( =     x   25 )  ( =     y   30 )  ( =     z   23 ) )  ( =     ( eq1      x  y  z )   30 ) ) )
  ( check-synth )



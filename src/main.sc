require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Start.

    state: Hello
        intent!: /hello
        random:
            a: Hello!
            a: Hi!
            a: Glad to see you, bro!

    state: Bye
        intent!: /bye
        random:
            a: Bye!
            a: See you!
    
    state: HowAreYou
        q!: [(* how *r* *u * | * what's up) *] 
        random:
            a: I'm fine, thanks! 
            a: Great, because I'm talking to you :)   
            a: All right! 😜
            a: Fricking cool, bro!
        a: Wanna chill?     
        go!: /SelectOption
        
    state: MainButtons
        buttons:
            "Это кнопка 1"
            "Это кнопка 2"
    
    state: /SelectOption
        inlineButtons:
            {text: "chillout music", url: "https://www.youtube.com/watch?v=KuDWifo1q1U&ab_channel=RelaxChilloutMusic"}
            {text: "fancy hip-hop clothes", url: "https://www.everythinghiphop.com/Clothing/"}
    
    state: NoMatch
        event!: noMatch
        random:
            a: Hey, bro, I don't understand. You said: {{$request.query}}
            a: Sorry bro, I don't understand you.

    state: Match
        event!: match
        a: {{$context.intent.answer}}
require: slotfilling/slotFilling.sc
  module = sys.zb-common
# require: name/name.sc
#   module = sys.zb-common  
# require: name/nameEn.sc
#   module = sys.zb-common  
theme: /
    
    state: Start || modal = true
        q!: $regex</start>
        a: Hey, what's your name?

        state: GetName
            q!: @pymorhy.name 
            a: Nice to meet you, {{$parseTree["_pymorhy.name"]}}!
            # buttons:
                # "what can I do?" -> /MainButtons
        go!: /MainButtons

    state: Hello
        intent!: /hello
        random:
            a: Hello!
            a: Hi!
            a: Glad to see you, bro!
        buttons:
            "what's up bro?" -> /HowAreYou
            "bye" -> /Bye   

    state: Bye
        intent!: /bye
        random:
            a: Bye!
            a: See you!
    
    state: HowAreYou
        q!: [(* how *r* *u * | * what's up | how do *u do *) *] 
        random:
            a: I'm fine, thanks! 
            a: Great, because I'm talking to you :)   
            a: All right! 😜
            a: Fricking cool, bro!
        a: Wanna chill?     
        go!: /SelectOption
        
    state: MainButtons
        buttons:
            "hello" -> /Hello
            "what's up bro?" -> /HowAreYou
            "bye" -> /Bye
            
    state: /SelectOption
        inlineButtons:
            {text: "chillout music", url: "https://www.youtube.com/watch?v=KuDWifo1q1U&ab_channel=RelaxChilloutMusic"}
            {text: "fancy hip-hop clothes", url: "https://www.everythinghiphop.com/Clothing/"}
    
    state: NoMatch
        event!: noMatch
        random:
            a: Hey, bro, I don't understand. You said: {{$request.query}}
            a: Sorry bro, I don't understand you.
        go!: /MainButtons    

    state: Match
        event!: match
        a: {{$context.intent.answer}}
def handle(event, context):
    symbol = event['symbol']

    result = {
        "company": {
            "name": "Company name",
            "symbol": symbol
        },
        "event": event
    }
    return result

from invest_guru.alpha_vantage.simple_moving_average import simple_moving_average


def handle(event, context):
    symbol = event['symbol']

    sma_50_days = simple_moving_average(symbol=symbol, time_period=50)
    sma_300_days = simple_moving_average(symbol=symbol, time_period=300)

    result = {
        "company": {
            "name": "Company name",
            "symbol": symbol
        },
        "sma": {
            "sma_50_days": sma_50_days,
            "sma_300_days": sma_300_days
        },
        "event": event
    }
    return result

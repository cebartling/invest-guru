from invest_guru.alpha_vantage.simple_moving_average import simple_moving_average
import redis


def handle(event, context):
    symbol = event['symbol']

    redis_client = redis.StrictRedis(host='<your ElastiCache endpoint DNS>', port=6379, db=0)
    company_info = redis_client.get(symbol)
    if company_info is None:
        sma_50_days = simple_moving_average(symbol=symbol, time_period=50)
        sma_300_days = simple_moving_average(symbol=symbol, time_period=300)
        company_info = {
            'sma_50_days': sma_50_days,
            'sma_300_days': sma_300_days
        }
        redis_client.set(symbol, company_info)
    else:
        sma_50_days = company_info['sma_50_days']
        sma_300_days = company_info['sma_300_days']

    result = {
        "company": {
            "name": "Company name",
            "symbol": symbol
        },
        "averages50": sma_50_days,
        "averages300": sma_300_days,
        "event": event
    }
    return result

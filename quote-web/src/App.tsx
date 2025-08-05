import React, { useState } from 'react';
import './App.css';

function App() {
  const [quote, setQuote] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const fetchQuote = async () => {
    setLoading(true);
    setError(null);
    try {
      const response = await fetch('http://localhost:8080/quote'); // backend API
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const text = await response.text();
      setQuote(text);
    } catch (err: any) {
      setError(err.message || 'Failed to fetch quote');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="app-container">
      <h1 className="app-title">Quote Web</h1>
      <button className="quote-button" onClick={fetchQuote} disabled={loading}>
        {loading ? 'Loading...' : 'Get Random Quote'}
      </button>
      {error && <p className="error-text">⚠️ {error}</p>}
      {quote && <blockquote className="quote-box">“{quote}”</blockquote>}
    </div>
  );
}

export default App;

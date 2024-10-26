import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "../../api/axios";

import "../../components/MovieModal/MovieModal.css";
export default function DetailPage() {
  const { movieId } = useParams();
  const [movie, setMovie] = useState({});

  useEffect(() => {
    async function fetchData() {
      const request = await axios.get(`/movie/${movieId}`);
      setMovie(request.data);
    }
    fetchData();
  }, [movieId]);

  if (!movie) return <div>...loading</div>;

  return (
    <section className="model">
      <img
        className="modal__poster-img"
        src={`https://image.tmdb.org/t/p/original/${movie.backdrop_path}`}
        alt="poster"
      />
      <div className="modal__content">
        <p className="modal__details">
          <span className="modal__user_perc">100% for you</span>{" "}
          {movie.release_date ? movie.release_date : movie.first_air_date}
        </p>

        <h2 className="modal__titletit">
          {movie.title || movie.name || movie.original_name}
        </h2>
        <p className="modal__overview"> 평점: {movie.vote_average}</p>
        {movie.genres && (
          <p className="modal__overview">
            {" "}
            장르:{" "}
            {movie.genres.map((g) => (
              <span key={g.id}>#{g.name} </span>
            ))}
          </p>
        )}
        <p className="modal__overview"> {movie.overview}</p>
      </div>
    </section>
  );
}
